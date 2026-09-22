package com.togetherweserve.app.data.repository;

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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001d0\u001cJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001cJ&\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010&\u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/togetherweserve/app/data/repository/EventRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "api", "Lcom/togetherweserve/app/data/remote/ApiService;", "appContext", "kotlin.jvm.PlatformType", "db", "Lcom/togetherweserve/app/data/local/AppDatabase;", "createGroup", "Lcom/togetherweserve/app/data/remote/models/CreateGroupResponse;", "eventId", "", "groupName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvent", "Lcom/togetherweserve/app/data/local/EventEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinEvent", "", "eventTitle", "eventDateTime", "", "groupCode", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeEvents", "Lkotlinx/coroutines/flow/Flow;", "", "observeSchedule", "Lcom/togetherweserve/app/data/local/RegistrationEntity;", "refreshEvents", "", "cause", "query", "refreshSchedule", "userId", "syncPendingActions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class EventRepository {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.togetherweserve.app.data.local.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.togetherweserve.app.data.remote.ApiService api = null;
    
    public EventRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.togetherweserve.app.data.local.EventEntity>> observeEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.togetherweserve.app.data.local.RegistrationEntity>> observeSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshEvents(@org.jetbrains.annotations.Nullable()
    java.lang.String cause, @org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.local.EventEntity> $completion) {
        return null;
    }
    
    /**
     * Individual or group join. Returns true if it went straight to the
     * server, false if it was queued for later sync while offline.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object joinEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    java.lang.String eventTitle, long eventDateTime, @org.jetbrains.annotations.Nullable()
    java.lang.String groupCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.remote.models.CreateGroupResponse> $completion) {
        return null;
    }
    
    /**
     * Called on connectivity-restored (e.g. from a WorkManager job or
     * ConnectivityManager callback) to replay anything queued offline.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncPendingActions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}