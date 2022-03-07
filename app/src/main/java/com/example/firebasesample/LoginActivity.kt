package com.example.firebasesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.firebasesample.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)


        signUp()
        logIn()



    }

    private fun logIn() {
        login_button.setOnClickListener {

        }
    }

    private fun signUp() {

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
                else ->{
                    var email =user_name.text.toString().trim{ it<= ' '}
                    var password=password.text.toString().trim{it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this,
                                    "You registered",
                                    Toast.LENGTH_LONG
                                ).show()
                               val intent = Intent (this,MainActivity::class.java)
                                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                intent.putExtra("user_id",firebaseUser.uid)
                                intent.putExtra("email_id",email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_LONG
                                ).show()

                            }
                        }


                }
            }




        }

    }
}