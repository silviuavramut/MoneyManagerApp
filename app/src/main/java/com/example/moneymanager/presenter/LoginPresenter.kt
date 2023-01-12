package com.example.moneymanager.presenter

import com.example.moneymanager.model.IUser
import com.example.moneymanager.model.User
import com.example.moneymanager.view.ILoginView


class LoginPresenter : ILoginPresenter{
    var iLoginView: ILoginView? = null
    var user: IUser? = null


    override fun doLogin(name: String?, password: String?) {
        var isLoginSuccess = true
        val code = user!!.checkUserValidity(name, password)
        if (code != 0) isLoginSuccess = false
    }
    
    private fun initUser() {
        user = User("test","test")
    }
}