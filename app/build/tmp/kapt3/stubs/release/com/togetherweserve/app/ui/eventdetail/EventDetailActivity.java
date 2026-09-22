package com.togetherweserve.app.ui.eventdetail;

/**
 * FR5 / FR6 / FR7 - shows full event info and lets the user register
 * individually or hand off to Group/Team Sign-up (the app's key
 * differentiator, per the Planning & Design document).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/togetherweserve/app/ui/eventdetail/EventDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "binding", "Lcom/togetherweserve/app/databinding/ActivityEventDetailBinding;", "currentEvent", "Lcom/togetherweserve/app/data/local/EventEntity;", "groupCode", "", "groupSignupLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "repository", "Lcom/togetherweserve/app/data/repository/EventRepository;", "selectedMode", "bind", "", "event", "confirmSignup", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_release"})
public final class EventDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.togetherweserve.app.databinding.ActivityEventDetailBinding binding;
    private com.togetherweserve.app.data.repository.EventRepository repository;
    @org.jetbrains.annotations.Nullable()
    private com.togetherweserve.app.data.local.EventEntity currentEvent;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedMode = "individual";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String groupCode;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> groupSignupLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_EVENT_ID = "extra_event_id";
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.ui.eventdetail.EventDetailActivity.Companion Companion = null;
    
    public EventDetailActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bind(com.togetherweserve.app.data.local.EventEntity event) {
    }
    
    private final void confirmSignup() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/togetherweserve/app/ui/eventdetail/EventDetailActivity$Companion;", "", "()V", "EXTRA_EVENT_ID", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}