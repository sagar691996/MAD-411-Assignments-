package com.example.assignment_1_sagarparmar_0857562

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FooterFragment : Fragment() {
    private var totalValue = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_footer, container, false)
    }

    fun updateTotalValue(amount: Double) {
        totalValue += amount
        view?.findViewById<TextView>(R.id.footerText)?.text = "Total: $$totalValue"
    }
}
