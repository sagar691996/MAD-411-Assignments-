package com.example.assignment_1_sagarparmar_0857562

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//this class is for the individual expenses
class ExpenseAdapter(private val expenseList: ArrayList<MainActivity.Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

        // ExpenseViewHolder
    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expensesName: TextView = itemView.findViewById(R.id.expensesName)
        val expenseAmount: TextView = itemView.findViewById(R.id.expenseAmount)
        val deleteButton: Button = itemView.findViewById(R.id.delete_button)
    }

    //oncreateViewHolder is fetch the data from the parent class to single tabview recycleView ad return the proper details to perform task
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_tabview_recycleview, parent, false)
        return ExpenseViewHolder(view)
    }

    //OnBindingViewHolder is fethcing the data from the holder and added to the single tabview holder
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.expensesName.text = expense.name
        holder.expenseAmount.text = expense.amount
        holder.deleteButton.setOnClickListener {
            expenseList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int = expenseList.size
}
