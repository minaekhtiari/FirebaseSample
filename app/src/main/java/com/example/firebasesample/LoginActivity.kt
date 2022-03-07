package com.example.firebasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.firebasesample.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.signupButton.setOnClickListener {
            when {
                TextUtils.isEmpty(user_name.text.toString().trim{ it<= ' '})->{
                    Toast.makeText(this,
                    "Please Enter Email",
                    Toast.LENGTH_LONG).show()

                }

                TextUtils.isEmpty(password.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this,
                        "Please Enter Password",
                        Toast.LENGTH_LONG).show()
                }
            }
        }




    }
}