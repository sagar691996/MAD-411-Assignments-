package com.example.assignment_1_sagarparmar_0857562

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
        expenseList = loadExpenses()
        adapter = ExpenseAdapter(expenseList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add Expense Button
        submitButton.setOnClickListener {
            val name = expenseInput.text.toString()
            val amount = expenseInputAmount.text.toString()

            if (name.isNotEmpty() && amount.isNotEmpty()) {
                val expenseAmount = amount.toDouble()
                val expense = Expense(name, amount)
                expenseList.add(expense)

                // Update FooterFragment with the new total
                updateFooterExpense(expenseAmount)

                // Save expenses to file
                saveExpenses()

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

    // Method to load expenses from the file
    private fun loadExpenses(): ArrayList<Expense> {
        val fileName = "expenses.json"
        val expenses = ArrayList<Expense>()
        try {
            val fileInputStream: FileInputStream = openFileInput(fileName)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val gson = Gson()
            val expenseListType = object : TypeToken<ArrayList<Expense>>() {}.type
            val loadedExpenses: ArrayList<Expense> = gson.fromJson(inputStreamReader, expenseListType)
            expenses.addAll(loadedExpenses)
        } catch (e: Exception) {
            Log.e("MainActivity", "Error loading expenses", e)
        }
        return expenses
    }

    // Method to save expenses to the file
    fun saveExpenses() {
        val fileName = "expenses.json"
        try {
            val fileOutputStream: FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            val gson = Gson()
            val json = gson.toJson(expenseList)
            outputStreamWriter.write(json)
            outputStreamWriter.close()
        } catch (e: Exception) {
            Log.e("MainActivity", "Error saving expenses", e)
        }
    }

    // Data class to represent an Expense
    data class Expense(
        val name: String,
        val amount: String
    )
}
