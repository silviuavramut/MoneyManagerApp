package com.example.moneymanager.presenter

import com.example.moneymanager.model.UserPojo

interface ILoginPresenter {

    fun doLogin(user : UserPojo)

}

interface ILoginCallback{
    fun onSuccesLogin()
    fun onErrorLogin()

}

