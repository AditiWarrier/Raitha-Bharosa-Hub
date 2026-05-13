package com.example.rbhapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)

        val countryInput = findViewById<EditText>(R.id.countryInput)
        val stateInput = findViewById<EditText>(R.id.stateInput)
        val regionInput = findViewById<EditText>(R.id.regionInput)

        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {

            val name = nameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            val country = countryInput.text.toString().trim()
            val state = stateInput.text.toString().trim()
            val region = regionInput.text.toString().trim()

            // Validation

            if (name.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                country.isEmpty() ||
                state.isEmpty() ||
                region.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (password.length < 6) {

                Toast.makeText(
                    this,
                    "Password must be at least 6 characters",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Firebase Authentication

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful()) {

                        // User ID

                        val userId = auth.currentUser?.uid

                        // User data map

                        val userMap = hashMapOf(
                            "name" to name,
                            "phone" to phone,
                            "email" to email,
                            "country" to country,
                            "state" to state,
                            "region" to region
                        )

                        // Store in Firestore

                        if (userId != null) {

                            db.collection("users")
                                .document(userId)
                                .set(userMap)
                                .addOnSuccessListener {

                                    Toast.makeText(
                                        this,
                                        "Registration Successful",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent = Intent(
                                        this,
                                        LoginActivity::class.java
                                    )

                                    startActivity(intent)
                                    finish()
                                }

                                .addOnFailureListener {

                                    Toast.makeText(
                                        this,
                                        "Failed to save user data",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        }

                    } else {

                        Toast.makeText(
                            this,
                            "Registration Failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}