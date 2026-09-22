package com.togetherweserve.app.utils;

/**
 * Pure filtering logic used by HomeFragment, pulled out into its own
 * object so it can be unit tested without needing an Android Context.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a8\u0006\n"}, d2 = {"Lcom/togetherweserve/app/utils/EventFilter;", "", "()V", "filter", "", "Lcom/togetherweserve/app/data/local/EventEntity;", "events", "query", "", "selectedCauses", "app_release"})
public final class EventFilter {
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.utils.EventFilter INSTANCE = null;
    
    private EventFilter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.togetherweserve.app.data.local.EventEntity> filter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.togetherweserve.app.data.local.EventEntity> events, @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> selectedCauses) {
        return null;
    }
}