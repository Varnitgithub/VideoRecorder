package com.example.consassessment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

lateinit var MyFirebaseauth: FirebaseAuth

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        MyFirebaseauth = com.google.firebase.auth.FirebaseAuth.getInstance()
        val buttonforlogin: Button = findViewById(R.id.buttonforlogin)
        val tosignup: TextView = findViewById(R.id.tosignup)
        buttonforlogin.setOnClickListener {
            forlogin()

        }
        tosignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun forlogin() {
        val emailforlogin: EditText = findViewById(R.id.editEmailAddressforlogin)
        val passwordlogin: EditText = findViewById(R.id.editTextPasswordforlogin)
        val loginEmail = emailforlogin.text.toString().trim()
        val loginpassword = passwordlogin.text.toString().trim()
        val currentuserlogin = MyFirebaseauth.currentUser
        if (loginEmail.isBlank() && loginpassword.isBlank()) {
            Toast.makeText(this, "Enter Email and Password", Toast.LENGTH_SHORT).show()


        } else {
            if (currentuserlogin != null) {
                MyFirebaseauth.signInWithEmailAndPassword(loginEmail, loginpassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "User Login Sucessfully", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, RecAct::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }

            }


        }
    }
}