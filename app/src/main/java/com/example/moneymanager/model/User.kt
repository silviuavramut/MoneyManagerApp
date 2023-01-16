package com.example .moneymanager.model

import android.util.Patterns
import com.example.moneymanager.model.IUser
import com.example.moneymanager.presenter.ILoginCallback
import com.example.moneymanager.presenter.IRegisterCallback

class User : IUser {

    private var firstName : String? = ""
    private var lastName : String? = ""
    private var email : String? = ""
    private var password : String? = ""
    private var listener : ILoginCallback? = null
    private var listener2 : IRegisterCallback? = null

    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

    constructor(firstName: String?, lastName: String?, email: String?, password: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.password = password
    }


    fun initOnLoginCallback(listener : ILoginCallback){
        this.listener=listener
    }
    fun initOnRegisterCallback(listener : IRegisterCallback){
        this.listener2=listener
    }

    override fun getDataFromBackendForUser(user: User){

        listener?.onSucces()

    }

    override fun postDataToBackendForUser(user: User) {
        listener2?.onSucces()
    }




    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getFirstName(): String? {
        return firstName
    }

    override fun getLastName(): String? {
        return lastName
    }

}