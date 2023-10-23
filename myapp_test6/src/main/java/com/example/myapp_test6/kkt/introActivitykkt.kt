package com.example.myapp_test6.kkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.myapp_test6.R

class introActivitykkt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(applicationContext, MainActivitykkt::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3초 있다 메인액티비티로
        setContentView(R.layout.activity_intro_activitykkt)
    }
}