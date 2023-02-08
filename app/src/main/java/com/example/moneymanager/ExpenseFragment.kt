package com.example.moneymanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.moneymanager.model.Expense
import com.example.moneymanager.model.ExpenseModel
import com.example.moneymanager.model.ExpensePojo
import com.example.moneymanager.presenter.ExpensePresenter
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.utils.CustomListAdapter
import com.example.moneymanager.view.IExpenseView
import com.google.android.material.bottomnavigation.BottomNavigationView


class ExpenseFragment : Fragment(), IExpenseView {
    
    lateinit var list: ListView
    lateinit var expenseDBArrayList: ArrayList<Expense>
    lateinit var expensePojoArrayList: ArrayList<ExpensePojo>


    override fun onCreate(savedInstanceState: Bundle?) {

        val expensePresenter = ExpensePresenter(this, ExpenseModel())
        expensePojoArrayList = ArrayList()
        expenseDBArrayList = expensePresenter.getExpenseList(requireContext())

        for (i in expenseDBArrayList) {
            val expensePojo = ExpensePojo(
                i.type,
                i.date,
                i.account,
                i.category,
                i.amount + getString(R.string.currency),
                i.note
            )
            expensePojoArrayList.add(expensePojo)
        }

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_expense, container, false)
        val button = view.findViewById<Button>(R.id.buttonAddExpense)
        val bottomNav =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        list = view.findViewById<ListView>(R.id.listViewExpenses)
        list.adapter = CustomListAdapter(requireActivity(), expensePojoArrayList)

        button.setOnClickListener {
            bottomNav.visibility = View.GONE
            getActivity()?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.fragmentLayout, AddExpenseFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
        return view
    }

    override fun redirect() {
        TODO("Not yet implemented")
    }


}