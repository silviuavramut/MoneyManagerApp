package com.example.moneymanager.presenter

import com.example.moneymanager.model.User

interface ILoginPresenter {

    fun doLogin(email:String,password:String)

}

interface ILoginCallback{
    fun onSucces()
    fun onError()

}

