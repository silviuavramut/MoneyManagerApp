package com.example.moneymanager.presenter

import com.example.moneymanager.model.UserPojo

interface IRegisterPresenter {

    fun doRegister(userPojo: UserPojo)
    fun OnSucces()
    fun onError(message : String)

}