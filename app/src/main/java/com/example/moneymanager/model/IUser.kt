package com.example.moneymanager.model

interface IUser {
    fun getName(): String?

    fun getPassword(): String?

    fun checkUserValidity(name: String?, password: String?): Int
}