package com.example.moneymanager.model

import android.content.Context

interface IExpenseModel {
    fun getExpenseDataFromPresenter(expense:ExpensePojo,context: Context)
    fun getExpenseListFromDB(context: Context) : ArrayList<Expense>
    fun expenseAddedInDB(onFinishedListener: OnExpenseFinishedListener)
}
interface OnExpenseFinishedListener {
    fun OnResultSucces()
    fun OnResultError()
}