package com.example.moneymanager.presenter

import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.view.IRegisterView

class RegisterPresenter (val iRegisterView:IRegisterView) :IRegisterPresenter {

    override fun doRegister(userPojo: UserPojo) {
    }

    override fun OnSucces() {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }

}