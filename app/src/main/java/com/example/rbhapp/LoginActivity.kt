package com.example.rbhapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val emailInput =
            findViewById<EditText>(R.id.emailInput)

        val passwordInput =
            findViewById<EditText>(R.id.passwordInput)

        val loginButton =
            findViewById<Button>(R.id.loginButton)

        val registerText =
            findViewById<TextView>(R.id.registerText)

        val languageButton =
            findViewById<Button>(R.id.languageButton)

        val titleText =
            findViewById<TextView>(R.id.titleText)

        val subtitleText =
            findViewById<TextView>(R.id.subtitleText)

        fun updateLanguageUI() {

            val isKannada =
                LanguageManager.isKannada.value

            if (isKannada) {

                languageButton.text =
                    "English"

                titleText.text =
                    "🌾 ರೈತ ಭರೋಸಾ ಹಬ್"

                subtitleText.text =
                    "ಸ್ಮಾರ್ಟ್ ಬಿತ್ತನೆ ಸಹಾಯಕ"

                emailInput.hint =
                    "ಇಮೇಲ್ ನಮೂದಿಸಿ"

                passwordInput.hint =
                    "ಪಾಸ್‌ವರ್ಡ್ ನಮೂದಿಸಿ"

                loginButton.text =
                    "ಲಾಗಿನ್"

                registerText.text =
                    "ಖಾತೆ ಇಲ್ಲವೇ? ನೋಂದಣಿ ಮಾಡಿ"

            } else {

                languageButton.text =
                    "ಕನ್ನಡ"

                titleText.text =
                    "🌾 Raitha Bharosa Hub"

                subtitleText.text =
                    "Smart Sowing Assistant"

                emailInput.hint =
                    "Enter Email"

                passwordInput.hint =
                    "Enter Password"

                loginButton.text =
                    "Login"

                registerText.text =
                    "Don't have an account? Register"
            }
        }

        updateLanguageUI()

        languageButton.setOnClickListener {

            LanguageManager.isKannada.value =
                !LanguageManager.isKannada.value

            updateLanguageUI()
        }

        loginButton.setOnClickListener {

            val email =
                emailInput.text.toString().trim()

            val password =
                passwordInput.text.toString().trim()

            val isKannada =
                LanguageManager.isKannada.value

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,

                    if (isKannada)
                        "ದಯವಿಟ್ಟು ಎಲ್ಲಾ ವಿವರಗಳನ್ನು ನಮೂದಿಸಿ"
                    else
                        "Please fill all fields",

                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(
                email,
                password
            )
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful()) {

                        Toast.makeText(
                            this,

                            if (isKannada)
                                "ಲಾಗಿನ್ ಯಶಸ್ವಿಯಾಗಿದೆ"
                            else
                                "Login Successful",

                            Toast.LENGTH_SHORT
                        ).show()

                        val intent =
                            Intent(
                                this,
                                OnboardingActivity::class.java
                            )

                        startActivity(intent)

                        finish()

                    } else {

                        Toast.makeText(
                            this,

                            task.exception?.message.toString(),

                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        registerText.setOnClickListener {

            val intent =
                Intent(
                    this,
                    RegisterActivity::class.java
                )

            startActivity(intent)
        }
    }
}