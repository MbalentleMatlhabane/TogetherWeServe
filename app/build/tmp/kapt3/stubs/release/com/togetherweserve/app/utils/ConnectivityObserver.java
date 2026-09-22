package com.togetherweserve.app.utils;

/**
 * Lightweight connectivity check used to decide whether the app should read
 * from the REST API or fall back to the RoomDB offline cache, and whether
 * queued pending actions should be flushed.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/togetherweserve/app/utils/ConnectivityObserver;", "", "()V", "isOnline", "", "context", "Landroid/content/Context;", "app_release"})
public final class ConnectivityObserver {
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.utils.ConnectivityObserver INSTANCE = null;
    
    private ConnectivityObserver() {
        super();
    }
    
    public final boolean isOnline(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
}