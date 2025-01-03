package com.example.smartshare

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        //find button by its ID and set click listener

        val showToastButton: Button = findViewById(R.id.btnShowToast)
        showToastButton.setOnClickListener {
            Toast.makeText(this, "Toast message displayed", Toast.LENGTH_SHORT).show()
        }



        //Find EditText for user input
        val editUserMessage: EditText = findViewById(R.id.editUserMessage)

        //find a send msg btn and set click listener
        val sendMessageToNextActivity: Button = findViewById(R.id.btnSendMsgToNextActivity)
        sendMessageToNextActivity.setOnClickListener {
            val message: String = editUserMessage.text.toString()

            val intent = Intent(this, SecondActivity :: class.java)

            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        //Find sharetootherapps btn and set onclick
        val shareToApps: Button = findViewById(R.id.btnSharetoOtherApps)
        shareToApps.setOnClickListener {

            val message: String = editUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to :"))
        }

        //find recyclerview btn and set onclick

        val recyclerViewBtn: Button = findViewById(R.id.btnRecyclerViewDemo)
        recyclerViewBtn.setOnClickListener {
            val intent = Intent(this, HobbiesActivity :: class.java)
            startActivity(intent)
        }

    }

}