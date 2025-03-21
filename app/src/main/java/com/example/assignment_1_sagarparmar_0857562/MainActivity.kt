package com.example.assignment_1_sagarparmar_0857562

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var expenseList: ArrayList<Expense>
    private lateinit var adapter: ExpenseAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fetch the data from xml file: activity main
        val expenseInput = findViewById<EditText>(R.id.editTextName)
        val expenseInputAmount = findViewById<EditText>(R.id.editTextName1)
        val submitButton = findViewById<Button>(R.id.button)
        val recyclerView = findViewById<RecyclerView>(R.id.expensesList)

        // Initialize the expense list and adapter
        expenseList = ArrayList()
        adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set up the Add Expense button
        submitButton.setOnClickListener {
            val name = expenseInput.text.toString()
            val amount = expenseInputAmount.text.toString()

            if (name.isNotEmpty() && amount.isNotEmpty()) {
                expenseList.add(Expense(name, amount))
                try {
                    adapter.notifyDataSetChanged()
                } catch (e: Exception) {
                    TODO("Not yet implemented")
                }
                expenseInput.text.clear()
                expenseInputAmount.text.clear()
            }
        }
    }

    // Data class for Expense
    data class Expense(
        val name: String,
        val amount: String
    )
}
