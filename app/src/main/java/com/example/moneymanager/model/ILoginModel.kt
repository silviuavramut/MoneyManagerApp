package com.example.moneymanager.model

import android.content.Context

interface ILoginModel {
    fun checkUserForLogin(user: UserPojo, context: Context): Boolean
    fun userSuccessfullyLoggedIn(onLoginFinishedListener: OnLoginFinishedListener)
    fun LogInFailed(onLoginFinishedListener: OnLoginFinishedListener)
}

interface OnLoginFinishedListener {
    fun OnResultSucces()
    fun OnResultError()
}