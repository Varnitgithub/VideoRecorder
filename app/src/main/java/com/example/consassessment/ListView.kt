package com.example.consassessment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListView : AppCompatActivity(), Adapter.setonitemclclick {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val recyclerview: RecyclerView = findViewById(R.id.Recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = Adapter(this)

    }

    override fun onitemclicks(items: RecordedVideo) {
        val intent = Intent(this, videoplayer::class.java)
        startActivity(intent)
    }
}