package com.example.moneymanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.moneymanager.view.IExpenseView
import com.google.android.material.bottomnavigation.BottomNavigationView


class ExpenseFragment : Fragment(),IExpenseView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_expense, container, false)
        val button = view.findViewById<Button>(R.id.buttonAddExpense)
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val iExpenseView: IExpenseView? = null

        button.setOnClickListener {
            bottomNav.visibility=View.GONE
            getActivity()?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.fragmentLayout, AddExpenseFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
        return view
    }



    override fun openAddFragment() {

    }

}