package com.example.moneymanager.presenter

import android.util.Patterns
import com.example.moneymanager.model.User
import com.example.moneymanager.view.ILoginView


class LoginPresenter(internal val iLoginView: ILoginView) : ILoginPresenter,ILoginCallback{
    override fun doLogin(email:String,password:String) {
        var user = User(email,password)
        user.initOnLoginCallback(this)


        if(loginValidation(user)==0){
            user.getDataFromBackendForUser(user)
        }
        else if(loginValidation(user)==1){
            iLoginView.showToastMessage("fields are empty")
        }
        else if(loginValidation(user)==2){
            iLoginView.showToastMessage("invalid email")
        }
        else if(loginValidation(user)==3){
            iLoginView.showToastMessage("password too short")
        }
        else if(loginValidation(user)==4){
            iLoginView.showToastMessage("invalid credentials")
        }


    }

    override fun onSucces(){
        iLoginView.Redirect()
    }
    override fun onError(){

    }

    private fun loginValidation(user: User) : Int{

        if (user.getEmail()!!.isEmpty() || user.getPassword()!!.isEmpty()){
            return 1
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()){
            return 2
        }
        if (user.getPassword()!!.length<3){
            return 3
        }
        if (!verifyCredentials(user)){
            return 4
        }
        return 0;
    }

    fun verifyCredentials(user: User) : Boolean{
        if (user.getEmail() == "test@yahoo.com"  && user.getPassword()=="test")
        {
            return true
        }
        return false
    }

}