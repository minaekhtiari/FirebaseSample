package com.example.firebasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId=intent.getStringExtra("user_id")
        val email=intent.getStringExtra("email_id")

        user_id.text=userId
        email_id.text=email
        logout_button.setOnClickListener{

        }


    }
}