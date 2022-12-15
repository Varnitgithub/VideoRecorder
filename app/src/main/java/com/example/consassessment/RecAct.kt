package com.example.consassessment

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlin.concurrent.thread

@SuppressLint("StaticFieldLeak")
lateinit var videoview: VideoView
var requestcode: Int = 111
lateinit var fireuri: Uri

@SuppressLint("StaticFieldLeak")
lateinit var button: Button

class RecAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec)
        videoview = findViewById(R.id.videoView)
        button = findViewById(R.id.button)
        val collection = MediaController(this)
        collection.setAnchorView(videoview)
        videoview.setMediaController(collection)

        val savedData:Button = findViewById(R.id.SavedData)

        savedData.setOnClickListener {
            val intent = Intent(this,ListView::class.java)
            startActivity(intent)
        }


        button.isEnabled = false
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),requestcode)

        }
        else
            button.isEnabled = true

        button.setOnClickListener {
            button.setBackgroundColor(Color.parseColor("#7B241C"))
            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(intent, 1111)

        }

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1111) {

            var mview = videoview.setVideoURI(data?.data)

            videoview.start()


        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            button.isEnabled = true
        }

    }
}
