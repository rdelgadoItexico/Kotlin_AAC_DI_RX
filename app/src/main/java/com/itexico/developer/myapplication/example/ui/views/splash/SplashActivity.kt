package com.itexico.developer.myapplication.example.ui.views.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.itexico.developer.myapplication.R
import com.itexico.developer.myapplication.example.utils.Constants
import com.itexico.developer.myapplication.example.ui.views.example.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * An example full-screen activity that disappears after a fix set of milliseconds
 */
class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fullscreen_content.systemUiVisibility =
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        scheduleSplash()
    }

    private fun scheduleSplash() {
        Handler().postDelayed(
                {
                    // After the splash screen duration, route to the right activity
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                },
                Constants.SPLASH_DURATION
        )
    }
}
