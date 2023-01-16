package com.example.moneymanager.presenter

interface IRegisterPresenter {

    fun doRegister(firstname:String,lastname:String,email:String,password:String)

}

interface IRegisterCallback{
    fun onSucces()
    fun onError()

}