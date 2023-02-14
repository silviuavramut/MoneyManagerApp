package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
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

    private lateinit var list: ListView
    private lateinit var expenseDBArrayList: ArrayList<Expense>
    private lateinit var expensePojoArrayList: ArrayList<ExpensePojo>

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
        list.isClickable=true
        list.setOnItemClickListener { parent, view, position, id ->

            val id = expenseDBArrayList[position].id
            val type = expenseDBArrayList[position].type
            val date = expenseDBArrayList[position].date
            val account = expenseDBArrayList[position].account
            val category = expenseDBArrayList[position].category
            val amount = expenseDBArrayList[position].amount
            val note = expenseDBArrayList[position].note

            val i = Intent(requireContext(),ExpenseDetailActivity::class.java)
            i.putExtra("id",id)
            i.putExtra("type",type)
            i.putExtra("date",date)
            i.putExtra("account",account)
            i.putExtra("category",category)
            i.putExtra("amount",amount)
            i.putExtra("note",note)
            startActivity(i)

        }

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