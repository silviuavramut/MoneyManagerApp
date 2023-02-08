package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.UserPojo

interface ILoginPresenter {
    fun sendUserInfoForLogin(user: UserPojo, context: Context)
}