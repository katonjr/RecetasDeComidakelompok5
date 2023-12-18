package com.example.recetasdecomida.View.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recetasdecomida.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var btnLogin: Button
    lateinit var firebase: FirebaseAuth

    override fun onStart() {
        super.onStart()
        //Membuat login sekali dan mengarahkan ke home
        if (firebase.currentUser != null)
            startActivity(Intent(this, MainActivity::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebase = FirebaseAuth.getInstance()
        editEmail = findViewById(R.id.emaillogin)
        editPassword = findViewById(R.id.passwordlogin)
        btnLogin = findViewById(R.id.buttonmasuk)

        btnLogin.setOnClickListener {
            val getEmail = editEmail.text.toString()
            val getPassword = editPassword.text.toString()
            if (getEmail.isEmpty()){
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (getPassword.isEmpty()){
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            firebase.signInWithEmailAndPassword(getEmail,getPassword).addOnSuccessListener {
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            firebase.signInWithEmailAndPassword(getEmail,getPassword).addOnFailureListener {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
            }

        }


        var signin: Button=findViewById(R.id.buttonkesignup)
        signin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun Validation(email:String,password:String,konteks:Context){
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(konteks, "Email atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }
    }
}