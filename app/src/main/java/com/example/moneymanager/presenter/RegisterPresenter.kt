package com.example.moneymanager.presenter

import android.util.Patterns
import com.example.moneymanager.model.User
import com.example.moneymanager.view.IRegisterView

class RegisterPresenter(internal val IRegisterView: IRegisterView) : IRegisterPresenter,IRegisterCallback {
    override fun doRegister(firstname: String, lastname: String, email: String, password: String) {
        var user = User(firstname,lastname,email,password)
        user.initOnRegisterCallback(this)


        if(registerValidation(user)==0){
            user.postDataToBackendForUser(user)
        }
        else if(registerValidation(user)==1){
            IRegisterView.showToastMessage("fields are empty")
        }
        else if(registerValidation(user)==2){
            IRegisterView.showToastMessage("invalid email")
        }
        else if(registerValidation(user)==3){
            IRegisterView.showToastMessage("password too short")
        }
    }

    override fun onSucces() {
        IRegisterView.Redirect()
    }

    override fun onError() {
    }

    private fun registerValidation(user: User) : Int{

        if (user.getFirstName()!!.isEmpty() || user.getLastName()!!.isEmpty() || user.getEmail()!!.isEmpty() || user.getPassword()!!.isEmpty()){
            return 1
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()){
            return 2
        }
        if (user.getPassword()!!.length<3){
            return 3
        }
        return 0
    }
}