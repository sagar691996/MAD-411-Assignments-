package com.example.assignment_1_sagarparmar_0857562

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.button)
        val textViewOutput = findViewById<TextView>(R.id.textView3)

        // Set button click listener
        button.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                textViewOutput.text = "Hello, $name!"
            } else {
                textViewOutput.text = "Please enter your name first"
            }
        }
    }
}