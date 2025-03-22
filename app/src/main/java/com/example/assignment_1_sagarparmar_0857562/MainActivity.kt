package com.example.assignment_1_sagarparmar_0857562


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var expenseList: ArrayList<Expense>
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifecycle", "onCreate called")



        //Fetch the data from xml file: activity main
        val expenseInput = findViewById<EditText>(R.id.editTextName)
        val expenseInputAmount = findViewById<EditText>(R.id.editTextName1)
        val submitButton = findViewById<Button>(R.id.button)
        val recyclerView = findViewById<RecyclerView>(R.id.expensesList)
        val browserButton = findViewById<Button>(R.id.browseButton)

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

                expenseInput.text.clear() //Clear the input
                expenseInputAmount.text.clear() // clear the amount edit view
                recyclerView.adapter = adapter // Display the list
            }
        }


        browserButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("https://www.financial-tips.com")

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "onDestroy called")
    }


    // Data class for Expense
    data class Expense(
        val name: String,
        val amount: String
    )
}
