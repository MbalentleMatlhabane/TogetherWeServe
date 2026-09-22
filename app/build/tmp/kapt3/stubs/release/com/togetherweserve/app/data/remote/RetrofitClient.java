package com.togetherweserve.app.data.remote;

/**
 * Builds the Retrofit client used to reach the Cloud Functions REST API.
 * BASE_URL points at the deployed Cloud Functions region/project - update
 * it after `firebase deploy --only functions`.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/togetherweserve/app/data/remote/RetrofitClient;", "", "()V", "BASE_URL", "", "api", "Lcom/togetherweserve/app/data/remote/ApiService;", "getApi", "()Lcom/togetherweserve/app/data/remote/ApiService;", "api$delegate", "Lkotlin/Lazy;", "authInterceptor", "Lokhttp3/Interceptor;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "app_release"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://us-central1-togetherweserve-39d3f.cloudfunctions.net/";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.Interceptor authInterceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.togetherweserve.app.data.remote.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.togetherweserve.app.data.remote.ApiService getApi() {
        return null;
    }
}