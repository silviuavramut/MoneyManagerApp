package com.example.moneymanager.model

interface IUser {
    fun getEmail(): String?

    fun getPassword(): String?

    fun getFirstName(): String?

    fun getLastName(): String?
}