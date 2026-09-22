package com.togetherweserve.app.data.repository

import android.content.Context
import com.togetherweserve.app.data.local.AppDatabase
import com.togetherweserve.app.data.local.EventEntity
import com.togetherweserve.app.data.local.PendingActionEntity
import com.togetherweserve.app.data.local.RegistrationEntity
import com.togetherweserve.app.data.remote.RetrofitClient
import com.togetherweserve.app.data.remote.models.CreateGroupRequest
import com.togetherweserve.app.data.remote.models.RegisterRequest
import com.togetherweserve.app.utils.ConnectivityObserver
import kotlinx.coroutines.flow.Flow

/**
 * Single source of truth for events and registrations.
 *
 * Read path: always read from RoomDB (Flow), which is refreshed from the
 * REST API whenever the device is online.
 *
 * Write path (join / cancel): if online, call the API directly and cache
 * the result. If offline, queue a PendingActionEntity and optimistically
 * update the local registration as "pending_sync" so My Schedule reflects
 * it immediately; syncPendingActions() replays the queue once reconnected.
 */
class EventRepository(context: Context) {

    private val appContext = context.applicationContext
    private val db = AppDatabase.getInstance(appContext)
    private val api = RetrofitClient.api

    fun observeEvents(): Flow<List<EventEntity>> = db.eventDao().observeAll()
    fun observeSchedule(): Flow<List<RegistrationEntity>> = db.registrationDao().observeAll()

    suspend fun refreshEvents(cause: String? = null, query: String? = null) {
        if (!ConnectivityObserver.isOnline(appContext)) return
        try {
            val remote = api.getEvents(cause, query)
            db.eventDao().upsertAll(remote.map {
                EventEntity(it.eventId, it.title, it.cause, it.description, it.dateTime,
                    it.location, it.slotsAvailable, it.volunteersGoing, it.organiserId, it.organiserName)
            })
        } catch (e: Exception) {
            // Network/API failure - keep showing whatever is already cached in Room
            // instead of crashing the app.
        }
    }

    suspend fun refreshSchedule(userId: String) {
        if (!ConnectivityObserver.isOnline(appContext)) return
        try {
            val remote = api.getSchedule(userId)
            db.registrationDao().upsertAll(remote.map {
                RegistrationEntity(it.registrationId, it.eventId, it.eventTitle, it.eventDateTime, it.groupId, it.status)
            })
        } catch (e: Exception) {
            // Network/API failure - keep showing whatever is already cached in Room
            // instead of crashing the app.
        }
    }

    suspend fun getEvent(eventId: String): EventEntity? {
        if (ConnectivityObserver.isOnline(appContext)) {
            return try {
                val remote = api.getEvent(eventId)
                EventEntity(remote.eventId, remote.title, remote.cause, remote.description,
                    remote.dateTime, remote.location, remote.slotsAvailable, remote.volunteersGoing,
                    remote.organiserId, remote.organiserName).also { db.eventDao().upsert(it) }
            } catch (e: Exception) {
                db.eventDao().getById(eventId)
            }
        }
        return db.eventDao().getById(eventId)
    }

    /** Individual or group join. Returns true if it went straight to the
     *  server, false if it was queued for later sync while offline. */
    suspend fun joinEvent(eventId: String, eventTitle: String, eventDateTime: Long, groupCode: String?): Boolean {
        return if (ConnectivityObserver.isOnline(appContext)) {
            val mode = if (groupCode != null) "group" else "individual"
            val response = api.registerForEvent(eventId, RegisterRequest(mode, groupCode))
            db.registrationDao().upsert(
                RegistrationEntity(response.registrationId, eventId, eventTitle, eventDateTime, groupCode, "confirmed")
            )
            true
        } else {
            db.pendingActionDao().insert(PendingActionEntity(eventId = eventId, actionType = "join", groupCode = groupCode))
            db.registrationDao().upsert(
                RegistrationEntity("local_$eventId", eventId, eventTitle, eventDateTime, groupCode, "pending_sync")
            )
            false
        }
    }

    suspend fun createGroup(eventId: String, groupName: String) = api.createGroup(eventId, CreateGroupRequest(groupName))

    /** Called on connectivity-restored (e.g. from a WorkManager job or
     *  ConnectivityManager callback) to replay anything queued offline. */
    suspend fun syncPendingActions() {
        if (!ConnectivityObserver.isOnline(appContext)) return
        val pending = db.pendingActionDao().getAll()
        for (action in pending) {
            try {
                if (action.actionType == "join") {
                    val mode = if (action.groupCode != null) "group" else "individual"
                    val response = api.registerForEvent(action.eventId, RegisterRequest(mode, action.groupCode))
                    db.registrationDao().updateStatus("local_${action.eventId}", "confirmed")
                }
                db.pendingActionDao().delete(action)
            } catch (e: Exception) {
                // Leave it queued; will retry on the next sync pass.
            }
        }
    }
}
