package com.togetherweserve.app.utils;

/**
 * Small wrapper around SharedPreferences for locally persisted, non-sensitive
 * user state: selected language, cached role and notification preferences.
 * Authentication itself is handled entirely by Firebase Auth.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bR$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/togetherweserve/app/utils/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "chatMessagesEnabled", "getChatMessagesEnabled", "()Z", "setChatMessagesEnabled", "(Z)V", "eventRemindersEnabled", "getEventRemindersEnabled", "setEventRemindersEnabled", "", "language", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "prefs", "Landroid/content/SharedPreferences;", "role", "getRole", "setRole", "clear", "", "Companion", "app_release"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "tws_session";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ROLE = "role";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LANGUAGE = "language";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_NOTIF_EVENTS = "notif_events";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_NOTIF_CHAT = "notif_chat";
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.utils.SessionManager.Companion Companion = null;
    
    public SessionManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getEventRemindersEnabled() {
        return false;
    }
    
    public final void setEventRemindersEnabled(boolean value) {
    }
    
    public final boolean getChatMessagesEnabled() {
        return false;
    }
    
    public final void setChatMessagesEnabled(boolean value) {
    }
    
    public final void clear() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/togetherweserve/app/utils/SessionManager$Companion;", "", "()V", "KEY_LANGUAGE", "", "KEY_NOTIF_CHAT", "KEY_NOTIF_EVENTS", "KEY_ROLE", "PREFS_NAME", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}