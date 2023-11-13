package com.example.recetasdecomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var signin: Button=findViewById(R.id.buttonkesignup)
        signin.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

    }
}