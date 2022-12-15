package com.example.consassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

lateinit var FirebaseAuth:FirebaseAuth
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forlogin: TextView = findViewById(R.id.forlogin)
        val buttonforsignup: Button = findViewById(R.id.buttonforsignup)
        FirebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance()

        forlogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        buttonforsignup.setOnClickListener {
            forsignup()
        }
    }

    private fun forsignup() {
        val currentuser = FirebaseAuth.currentUser
        val edittableEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val edittablepassword: EditText = findViewById(R.id.editTextPasswordSignup)
        val edittableconfermpassword: EditText = findViewById(R.id.editTextconfermPassword)
        val EmailString = edittableEmail.text.toString().trim()
        val passwordString = edittablepassword.text.toString().trim()
        val confermpasswordString = edittableconfermpassword.text.toString()

        if (EmailString.isBlank() && passwordString.isBlank() && confermpasswordString.isBlank()) {
            Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
        } else if (passwordString != confermpasswordString) {
            Toast.makeText(this, "password does not match", Toast.LENGTH_SHORT).show()
        } else {

            FirebaseAuth.createUserWithEmailAndPassword(EmailString, passwordString)
                .addOnCompleteListener(this) {task->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "user register successfully", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, RecAct::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

        }
    }
}