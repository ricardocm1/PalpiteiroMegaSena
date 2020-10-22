package com.android.palpiteiromegasena.modules.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.palpiteiromegasena.R
import com.android.palpiteiromegasena.extensions.postDelayed
import com.android.palpiteiromegasena.modules.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        postDelayed(2000) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}