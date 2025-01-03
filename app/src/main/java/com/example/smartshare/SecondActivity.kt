package com.example.smartshare

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val bundle: Bundle? = intent.extras
       val msg =  bundle!!.getString( "user_message")

        Toast.makeText(this, msg, Toast.LENGTH_SHORT ).show()

        val userMsg: TextView = findViewById(R.id.txvUserMessage)
        userMsg.text = msg
    }
}