package com.example .moneymanager.model

import android.util.Patterns
import com.example.moneymanager.model.IUser
import com.example.moneymanager.presenter.ILoginCallback

class User : IUser {

    private var email : String? = ""
    private var password : String? = ""
    private var listener : ILoginCallback? = null

    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

    fun initOnLoginCallback(listener : ILoginCallback){
        this.listener=listener
    }

    override fun getDataFromBackendForUser(user: User){

        listener?.onSucces()

    }

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

}