package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.Expense
import com.example.moneymanager.model.ExpenseModel
import com.example.moneymanager.model.ExpensePojo
import com.example.moneymanager.model.OnExpenseFinishedListener
import com.example.moneymanager.view.IExpenseView

class ExpensePresenter(private var expenseView: IExpenseView, private val model: ExpenseModel) :
    IExpensePresenter,
    OnExpenseFinishedListener {
    override fun sendExpenseInfo(expense: ExpensePojo, context: Context) {
        model.getExpenseDataFromPresenter(expense, context)
        model.expenseAddedInDB(this)
    }

    override fun getExpenseList(context: Context) : ArrayList<Expense> {
        return model.getExpenseListFromDB(context)
    }

    override fun deleteExpense(expenseID: String, context: Context) {
        model.deleteExpense(expenseID,context)
        model.expenseDeletedFromDB(this)
    }

    override fun updateExpense(expense: Expense, context: Context) {
        model.updateExpenseInDB(expense,context)
        model.expenseUpdatedInDB(this)
    }

    override fun OnResultSucces() {
        expenseView.redirect()
    }

    override fun OnResultError() {
        TODO("Not yet implemented")
    }


}