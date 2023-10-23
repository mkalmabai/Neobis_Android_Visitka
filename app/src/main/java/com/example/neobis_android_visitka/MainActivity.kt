package com.example.neobis_android_visitka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doctor1Layout = findViewById<LinearLayout>(R.id.doctor1)

        doctor1Layout.setOnClickListener {
            val intent = Intent(this, Detail_activity::class.java)
            startActivity(intent)
        }
    }
}