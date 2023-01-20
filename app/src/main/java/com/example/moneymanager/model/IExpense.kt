package com.example.moneymanager.model

interface IExpense {
    fun getType(): String?

    fun getDate(): String?

    fun getAccount(): String?

    fun getCategory(): String?

    fun getAmount(): String?

    fun getNote(): String?

}