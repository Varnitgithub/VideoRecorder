package com.example.consassessment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class videoplayer : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)
        val finalvideoplay:VideoView = findViewById(R.id.Finalvideoplay)


    }
}