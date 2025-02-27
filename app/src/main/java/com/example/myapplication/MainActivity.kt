package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            startActivity(Intent(this, SaveDataActivity::class.java))
        }

        findViewById<Button>(R.id.btnView).setOnClickListener {
            startActivity(Intent(this, ViewDataActivity::class.java))
        }
    }
}