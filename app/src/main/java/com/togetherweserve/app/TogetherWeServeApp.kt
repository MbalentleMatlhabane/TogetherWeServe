package com.togetherweserve.app

import android.app.Application
import com.togetherweserve.app.data.local.AppDatabase

/**
 * Application entry point. Firebase is auto-initialised by the
 * com.google.gms.google-services plugin using google-services.json.
 */
class TogetherWeServeApp : Application() {

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }

    override fun onCreate() {
        super.onCreate()
        // Room database and Retrofit client are lazily created on first use.
    }
}
