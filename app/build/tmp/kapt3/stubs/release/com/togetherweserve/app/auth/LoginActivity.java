package com.togetherweserve.app.auth;

/**
 * FR1 / FR2 - Registration & secure login, including Google Sign-In (SSO).
 * Firebase Authentication handles password hashing/storage server-side;
 * this app never stores or transmits a plain-text password itself.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/togetherweserve/app/auth/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/togetherweserve/app/databinding/ActivityLoginBinding;", "googleSignInLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "firebaseAuthWithGoogle", "", "idToken", "", "goToMain", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setLoading", "loading", "", "showError", "app_release"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.togetherweserve.app.databinding.ActivityLoginBinding binding;
    private com.google.firebase.auth.FirebaseAuth auth;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleSignInLauncher;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void firebaseAuthWithGoogle(java.lang.String idToken) {
    }
    
    private final void goToMain() {
    }
    
    private final void setLoading(boolean loading) {
    }
    
    private final void showError() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
}