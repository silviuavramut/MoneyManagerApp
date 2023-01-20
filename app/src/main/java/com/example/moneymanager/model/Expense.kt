package com.example.moneymanager.model

class Expense :IExpense{
    private var type : String? = ""
    private var date : String? = ""
    private var account : String? = ""
    private var category : String? = ""
    private var amount : String? = ""
    private var note : String? = ""

    constructor(
        type: String?,
        date: String?,
        account: String?,
        category: String?,
        amount: String?,
        note: String?
    ) {
        this.type = type
        this.date = date
        this.account = account
        this.category = category
        this.amount = amount
        this.note = note
    }


    override fun getType(): String? {
        return type
    }

    override fun getDate(): String? {
        return date
    }

    override fun getAccount(): String? {
        return account
    }

    override fun getCategory(): String? {
        return category
    }

    override fun getAmount(): String? {
        return amount
    }

    override fun getNote(): String? {
        return note
    }
}