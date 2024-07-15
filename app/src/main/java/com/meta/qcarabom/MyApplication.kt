package com.meta.qcarabom

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MyApplication : Application() {
    lateinit var mFirebaseAnalytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        // starta o Firebase
        mFirebaseAnalytics = Firebase.analytics
    }
}
