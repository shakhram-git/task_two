package com.example.myapplication

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class App : Application() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        var firstActivityCreated = false

        registerActivityLifecycleCallbacks(object :
            ActivityLifecycleCallbacks {

            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {
                if (firstActivityCreated) {
                    return
                }
                firstActivityCreated = true
            }

            override fun onActivityStarted(p0: Activity) {}
            override fun onActivityResumed(p0: Activity) {}
            override fun onActivityPaused(p0: Activity) {}
            override fun onActivityStopped(p0: Activity) {}
            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
            override fun onActivityDestroyed(p0: Activity) {}
        })
        Handler(Looper.getMainLooper()).post {
            if (firstActivityCreated) {
                prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
                val count = prefs.getInt(COUNT_KEY, 0)
                prefs.edit().putInt(COUNT_KEY, count + 1).apply()
            }
        }
    }
}