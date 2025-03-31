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
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_viewtable)

        val expensesName1 =findViewById<TextView>(R.id.expensesName1)

        val expensesAmount1 =findViewById<TextView>(R.id.expenseAmount1)



        val name = intent.getStringExtra("COUNTER_NAME")
        val amount = intent.getStringExtra("COUNTER_AMOUNT")

        expensesName1.text ="Name: $name"
        expensesAmount1.text = "Amount: $amount"


    }
}