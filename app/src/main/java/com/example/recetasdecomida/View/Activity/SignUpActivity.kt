package com.example.recetasdecomida.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recetasdecomida.R
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
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
        btnSignup = findViewById(R.id.buttonsimpanakun)



        btnSignup.setOnClickListener {
            val getEmail = editEmail.text.toString()
            val getPassword = editPassword.text.toString()

            setEmailAndPassword(getEmail,getPassword)

            firebase.createUserWithEmailAndPassword(
                getEmail,getPassword
            ).addOnSuccessListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }





        var loginn: Button =findViewById(R.id.buttonkelogin)
        loginn.setOnClickListener({val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)})
    }

   fun setEmailAndPassword(email: String,password: String){
       if (email.isEmpty() || password.isEmpty()){
           return
       }




    }
}