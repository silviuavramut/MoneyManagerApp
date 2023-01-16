package com.example.moneymanager.presenter

interface ILoginPresenter {

    fun doLogin(email:String,password:String)

}

interface ILoginCallback{
    fun onSucces()
    fun onError()

}

