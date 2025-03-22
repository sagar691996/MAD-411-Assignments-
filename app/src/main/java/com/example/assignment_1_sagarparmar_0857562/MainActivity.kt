package com.example.assignment_1_sagarparmar_0857562

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var expenseList: ArrayList<Expense>
    private lateinit var adapter: ExpenseAdapter
    private lateinit var footerFragment: FooterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ActivityLifecycle", "onCreate called")

        // Initialize and attach FooterFragment
        footerFragment = FooterFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.footerContainer, footerFragment)
            .commit()

        // Fetch UI elements from activity_main.xml
        val expenseInput = findViewById<EditText>(R.id.editTextName)
        val expenseInputAmount = findViewById<EditText>(R.id.editTextName1)
        val submitButton = findViewById<Button>(R.id.button)
        val recyclerView = findViewById<RecyclerView>(R.id.expensesList)
        val browserButton = findViewById<Button>(R.id.browseButton)

        // Initialize RecyclerView and Adapter
        expenseList = ArrayList()
        adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add Expense Button
        submitButton.setOnClickListener {
            val name = expenseInput.text.toString()
            val amount = expenseInputAmount.text.toString()

            if (name.isNotEmpty() && amount.isNotEmpty()) {
                val expenseAmount = amount.toDouble()
                expenseList.add(Expense(name, amount))

                // Update FooterFragment with the new total
                updateFooterExpense(expenseAmount)

                // Clear input fields and refresh RecyclerView
                expenseInput.text.clear()
                expenseInputAmount.text.clear()
                recyclerView.adapter = adapter
            }
        }

        // Browser Button
        browserButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.investopedia.com/financial-tips-for-young-adults-11678397"))
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

    // Function to update the total value in FooterFragment
    private fun updateFooterExpense(value: Double) {
        footerFragment.updateTotalValue(value)
    }

    // Data class to represent an Expense
    data class Expense(
        val name: String,
        val amount: String
    )
}
