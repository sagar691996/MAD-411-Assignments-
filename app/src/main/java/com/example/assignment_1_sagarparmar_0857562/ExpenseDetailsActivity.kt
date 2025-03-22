package com.example.assignment_1_sagarparmar_0857562

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_viewtable)

        // Retrieve the data from the previous page
        val name = intent.getStringExtra("name")
        val amount = intent.getStringExtra("amount")

        findViewById<TextView>(R.id.expensesName).text = "Name: $name"
        findViewById<TextView>(R.id.expensesAmount).text = "Amount: $amount"


    }
}