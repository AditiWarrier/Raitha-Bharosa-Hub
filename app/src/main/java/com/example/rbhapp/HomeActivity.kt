package com.example.rbhapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val dashboardButton =
            findViewById<Button>(R.id.dashboardButton)

        val inputButton =
            findViewById<Button>(R.id.inputButton)

        val calendarButton =
            findViewById<Button>(R.id.calendarButton)

        val historyButton =
            findViewById<Button>(R.id.historyButton)

        dashboardButton.setOnClickListener {

            val intent =
                Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        inputButton.setOnClickListener {

            Toast.makeText(
                this,
                "Input Center coming soon",
                Toast.LENGTH_SHORT
            ).show()
        }

        calendarButton.setOnClickListener {

            Toast.makeText(
                this,
                "Krishi Calendar coming soon",
                Toast.LENGTH_SHORT
            ).show()
        }

        historyButton.setOnClickListener {

            Toast.makeText(
                this,
                "History page coming soon",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}