package com.togetherweserve.app.ui.group;

/**
 * FR7 - Group/Team sign-up: create a named group (server generates a
 * shareable invite code) or enter an existing code to join a group already
 * registered for this event. This is TogetherWeServe's key differentiator
 * from the three researched apps (POINT, SignUp.com, Eventvolunteers).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/togetherweserve/app/ui/group/GroupSignupActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "binding", "Lcom/togetherweserve/app/databinding/ActivityGroupSignupBinding;", "eventId", "", "repository", "Lcom/togetherweserve/app/data/repository/EventRepository;", "finishWithCode", "", "code", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_release"})
public final class GroupSignupActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.togetherweserve.app.databinding.ActivityGroupSignupBinding binding;
    private com.togetherweserve.app.data.repository.EventRepository repository;
    private java.lang.String eventId;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope appScope = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_EVENT_ID = "extra_event_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESULT_GROUP_CODE = "result_group_code";
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.ui.group.GroupSignupActivity.Companion Companion = null;
    
    public GroupSignupActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void finishWithCode(java.lang.String code) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/togetherweserve/app/ui/group/GroupSignupActivity$Companion;", "", "()V", "EXTRA_EVENT_ID", "", "RESULT_GROUP_CODE", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}