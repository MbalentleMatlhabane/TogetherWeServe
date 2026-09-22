package com.togetherweserve.app.data.remote;

/**
 * Custom REST API exposed by Firebase Cloud Functions (see /functions).
 * The Android client never talks to Firestore/FCM directly - every call
 * here goes through this HTTPS layer, which verifies the Firebase ID
 * token supplied in the Authorization header before touching the database.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00112\b\b\u0001\u0010\u0017\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u0017\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/togetherweserve/app/data/remote/ApiService;", "", "createEvent", "Lcom/togetherweserve/app/data/remote/models/CreateEventResponse;", "body", "Lcom/togetherweserve/app/data/remote/models/CreateEventRequest;", "(Lcom/togetherweserve/app/data/remote/models/CreateEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGroup", "Lcom/togetherweserve/app/data/remote/models/CreateGroupResponse;", "eventId", "", "Lcom/togetherweserve/app/data/remote/models/CreateGroupRequest;", "(Ljava/lang/String;Lcom/togetherweserve/app/data/remote/models/CreateGroupRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvent", "Lcom/togetherweserve/app/data/remote/models/EventDto;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEvents", "", "cause", "query", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "Lcom/togetherweserve/app/data/remote/models/RegistrationDto;", "userId", "registerForEvent", "Lcom/togetherweserve/app/data/remote/models/RegisterResponse;", "Lcom/togetherweserve/app/data/remote/models/RegisterRequest;", "(Ljava/lang/String;Lcom/togetherweserve/app/data/remote/models/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSettings", "", "Lcom/togetherweserve/app/data/remote/models/SettingsUpdateRequest;", "(Ljava/lang/String;Lcom/togetherweserve/app/data/remote/models/SettingsUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "events")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEvents(@retrofit2.http.Query(value = "cause")
    @org.jetbrains.annotations.Nullable()
    java.lang.String cause, @retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.togetherweserve.app.data.remote.models.EventDto>> $completion);
    
    @retrofit2.http.GET(value = "events/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEvent(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.remote.models.EventDto> $completion);
    
    @retrofit2.http.POST(value = "events")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createEvent(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.togetherweserve.app.data.remote.models.CreateEventRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.remote.models.CreateEventResponse> $completion);
    
    @retrofit2.http.POST(value = "events/{id}/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerForEvent(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.togetherweserve.app.data.remote.models.RegisterRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.remote.models.RegisterResponse> $completion);
    
    @retrofit2.http.POST(value = "events/{id}/group")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createGroup(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.togetherweserve.app.data.remote.models.CreateGroupRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.togetherweserve.app.data.remote.models.CreateGroupResponse> $completion);
    
    @retrofit2.http.GET(value = "users/{id}/schedule")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSchedule(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.togetherweserve.app.data.remote.models.RegistrationDto>> $completion);
    
    @retrofit2.http.PATCH(value = "users/{id}/settings")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSettings(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.togetherweserve.app.data.remote.models.SettingsUpdateRequest body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Custom REST API exposed by Firebase Cloud Functions (see /functions).
     * The Android client never talks to Firestore/FCM directly - every call
     * here goes through this HTTPS layer, which verifies the Firebase ID
     * token supplied in the Authorization header before touching the database.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}