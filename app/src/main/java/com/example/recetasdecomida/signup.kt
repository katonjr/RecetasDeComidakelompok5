package com.example.recetasdecomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class signup : AppCompatActivity() {
    lateinit var editEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        var loginn: Button =findViewById(R.id.buttonkelogin)
        loginn.setOnClickListener({val intent = Intent(this, login::class.java)
            startActivity(intent)})
    }
}