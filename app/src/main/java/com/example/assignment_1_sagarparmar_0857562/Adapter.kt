package com.example.assignment_1_sagarparmar_0857562

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val expenseList: ArrayList<MainActivity.Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expensesName: TextView = itemView.findViewById(R.id.expensesName)
        val expenseAmount: TextView = itemView.findViewById(R.id.expenseAmount)
        val deleteButton: Button = itemView.findViewById(R.id.delete_button)
        val showDetails: Button = itemView.findViewById(R.id.show_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_tabview_recycleview, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.expensesName.text = expense.name
        holder.expenseAmount.text = expense.amount

        holder.deleteButton.setOnClickListener {
            expenseList.removeAt(position)
            notifyItemRemoved(position)
        }

        holder.showDetails.setOnClickListener {
            val intent = Intent(holder.itemView.context, ExpenseDetailsActivity::class.java)
            intent.putExtra("COUNTER_NAME", expense.name)
            intent.putExtra("COUNTER_AMOUNT", expense.amount)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = expenseList.size
}
