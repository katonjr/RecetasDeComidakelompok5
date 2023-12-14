package com.example.recetasdecomida

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var btnSignup: Button
    lateinit var  firebase: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        firebase = FirebaseAuth.getInstance()
        editEmail = findViewById(R.id.emailsignup)
        editPassword = findViewById(R.id.passwordsignup)
        btnSignup = findViewById(R.id.buttonkesignup)



        btnSignup.setOnClickListener {
            val getEmail = editEmail.text.toString()
            val getPassword = editPassword.text.toString()

            setEmailAndPassword(getEmail,getPassword)

            firebase.createUserWithEmailAndPassword(
                getEmail,getPassword
            ).addOnSuccessListener {
                val intent = Intent(this,login::class.java)
                startActivity(intent)
            }
        }





        var loginn: Button =findViewById(R.id.buttonlogin)
        loginn.setOnClickListener({val intent = Intent(this, login::class.java)
            startActivity(intent)})
    }

   fun setEmailAndPassword(email: String,password: String){
       if (email.isEmpty() || password.isEmpty()){
           return
       }




    }
}