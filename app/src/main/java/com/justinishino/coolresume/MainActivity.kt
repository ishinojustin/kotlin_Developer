package com.justinishino.coolresume

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistoryButton)

        var call = findViewById<Button>(R.id.callButton)

        var emailButton = findViewById<Button>(R.id.emailButon)

        workHistory.setOnClickListener {
            // Work History Activity Code
            println("You hit the button!")

            var moveToWorkHistory = Intent(getApplicationContext(), workHistoryActivity::class.java)
            startActivity(moveToWorkHistory)
        }

        call.setOnClickListener {
            println("Call")

            var phoneUri = Uri.parse("tel: 12082404373")
            var callIntent = Intent(Intent.ACTION_DIAL,phoneUri)
            startActivity(callIntent)
        }

        emailButton.setOnClickListener {
            println("Email")

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "jishino89@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nice Resume :)")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I really enjoyed your resume!")

            startActivity(emailIntent)
        }
    }
}