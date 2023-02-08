package com.example.moneymanager.presenter

import android.content.Context
import com.example.moneymanager.model.LoginModel
import com.example.moneymanager.model.OnLoginFinishedListener
import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.view.ILoginView


class LoginPresenter(private var loginView: ILoginView, private val model: LoginModel) :
    ILoginPresenter,
    OnLoginFinishedListener {

    override fun sendUserInfoForLogin(user: UserPojo, context: Context) {
        if (
            model.checkUserForLogin(user, context)) {
            model.userSuccessfullyLoggedIn(this)
        } else {
            model.LogInFailed(this)
        }
    }

    override fun OnResultSucces() {
        loginView.Redirect()
    }

    override fun OnResultError() {
        loginView.showMessage("account doesn't exist")
    }


}