package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.User
import com.example.moneymanager.model.UserPojo

interface IRegisterPresenter {
    fun sendUserInfo(user: UserPojo, context: Context)
    fun checkIfUserExists(userEmail: String, context: Context): Boolean
}