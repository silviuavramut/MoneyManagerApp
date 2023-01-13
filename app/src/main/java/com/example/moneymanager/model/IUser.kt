package com.example.moneymanager.model

interface IUser {
    fun getEmail(): String?

    fun getPassword(): String?

    fun getDataFromBackendForUser(user: User)
}