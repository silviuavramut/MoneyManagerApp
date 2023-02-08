package com.example.moneymanager.model

import android.content.Context
import com.example.moneymanager.sqlite.DBHelper

class ExpenseModel : IExpenseModel {
    private lateinit var expenseDBHelper: DBHelper
    override fun getExpenseDataFromPresenter(expense: ExpensePojo, context: Context) {
        expenseDBHelper = DBHelper(context)
        expenseDBHelper.insertExpense(
            Expense(
                type = expense.getType().toString(),
                date = expense.getDate().toString(),
                account = expense.getAccount().toString(),
                category = expense.getCategory().toString(),
                amount = expense.getAmount().toString(),
                note = expense.getNote().toString()
            )
        )
    }

    override fun getExpenseListFromDB(context: Context): ArrayList<Expense> {
        expenseDBHelper = DBHelper(context)
        return expenseDBHelper.getAllExpense()
    }

    override fun expenseAddedInDB(onFinishedListener: OnExpenseFinishedListener) {
        onFinishedListener.OnResultSucces()
    }
}