package com.example.assignment_1_sagarparmar_0857562

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var enteredTextView: EditText //TODO look up documentation
    private lateinit var nameTextView: TextView //TODO look up documentation
    private lateinit var showText: Button //TODO look up documentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        enteredTextView = findViewById(R.id.editTextName)
        showText = findViewById(R.id.button)
        nameTextView = findViewById(R.id.textView4)

        // Set button click listener
        showText.setOnClickListener {
            val name = enteredTextView.text.toString().trim()
            if (name.isNotEmpty()) {
                nameTextView.text = "Hello, $name!"
            } else {
                nameTextView.text = "Please enter your name first"
            }
        }
    }

    fun ShowName(view: View) {}
}