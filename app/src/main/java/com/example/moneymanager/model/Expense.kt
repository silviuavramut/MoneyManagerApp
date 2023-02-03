package com.example.moneymanager.model

class Expense(val id: Int = -1,
              val type: String,
              val date: String,
              val account: String,
              val category: String,
              val amount: String,
              val note: String)