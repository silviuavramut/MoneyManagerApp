package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.Expense
import com.example.moneymanager.model.ExpensePojo

interface IExpensePresenter {
    fun sendExpenseInfo(expense: ExpensePojo, context: Context)
    fun getExpenseList(context: Context) : ArrayList<Expense>
    fun deleteExpense(expenseID:String, context:Context)
    fun updateExpense(expense: Expense,context: Context)
}