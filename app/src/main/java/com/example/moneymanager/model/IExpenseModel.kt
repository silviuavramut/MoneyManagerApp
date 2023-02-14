package com.example.moneymanager.model

import android.content.Context

interface IExpenseModel {
    fun getExpenseDataFromPresenter(expense:ExpensePojo,context: Context)
    fun getExpenseListFromDB(context: Context) : ArrayList<Expense>
    fun expenseAddedInDB(onFinishedListener: OnExpenseFinishedListener)
    fun deleteExpense(expenseID:String,context:Context)
    fun expenseDeletedFromDB(onFinishedListener: OnExpenseFinishedListener)
    fun updateExpenseInDB(expense: Expense,context: Context)
    fun expenseUpdatedInDB(onFinishedListener: OnExpenseFinishedListener)

}
interface OnExpenseFinishedListener {
    fun OnResultSucces()
    fun OnResultError()
}