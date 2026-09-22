package com.togetherweserve.app.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistrationDao {
    @Query("SELECT * FROM registrations ORDER BY eventDateTime ASC")
    fun observeAll(): Flow<List<RegistrationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(registrations: List<RegistrationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(registration: RegistrationEntity)

    @Query("UPDATE registrations SET status = :status WHERE registrationId = :id")
    suspend fun updateStatus(id: String, status: String)

    @Query("DELETE FROM registrations")
    suspend fun clear()
}
