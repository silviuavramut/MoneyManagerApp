package com.example.moneymanager.model

import android.content.Context
import com.example.moneymanager.sqlite.DBHelper

class LoginModel : ILoginModel {
    private lateinit var usersDBHelper: DBHelper

    override fun checkUserForLogin(user: UserPojo, context: Context): Boolean {
        usersDBHelper = DBHelper(context)
        if (usersDBHelper.checkUser(user.getEmail().toString(), user.getPassword().toString())) {
            return true
        }
        return false
    }

    override fun userSuccessfullyLoggedIn(onLoginFinishedListener: OnLoginFinishedListener) {
        onLoginFinishedListener.OnResultSucces()
    }

    override fun LogInFailed(onLoginFinishedListener: OnLoginFinishedListener) {
        onLoginFinishedListener.OnResultError()
    }
}