package com.example.moneymanager.model

import android.content.Context

interface IRegisterModel {
    fun getUserDataFromPresenter(user: UserPojo, context: Context)
    fun userAddedInDB(onFinishedListener: OnRegisterFinishedListener)
    fun checkUserEmail(userEmail: String, context: Context): Boolean
}

interface OnRegisterFinishedListener {
    fun OnResultSucces()
    fun OnResultError()
}