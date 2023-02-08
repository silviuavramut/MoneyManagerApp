package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.RegisterModel
import com.example.moneymanager.model.OnRegisterFinishedListener
import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.view.IRegisterView

class RegisterPresenter(private var registerView: IRegisterView, private val model: RegisterModel) :
    IRegisterPresenter,
    OnRegisterFinishedListener {


    override fun sendUserInfo(user: UserPojo, context: Context) {
        model.getUserDataFromPresenter(user, context)
        model.userAddedInDB(this)
    }

    override fun checkIfUserExists(userEmail: String, context: Context): Boolean {
        return model.checkUserEmail(userEmail, context)
    }


    override fun OnResultSucces() {
        registerView.redirect()
    }

    override fun OnResultError() {
        registerView.showMessage("error")
    }

}