package com.example.moneymanager.model

import android.content.Context
import com.example.moneymanager.sqlite.DBHelper

class RegisterModel : IRegisterModel {
    private lateinit var usersDBHelper: DBHelper

    override fun getUserDataFromPresenter(user: UserPojo, context: Context) {
        usersDBHelper = DBHelper(context)
        usersDBHelper.insertUser(
            User(
                firstName = user.getFirstName().toString(),
                lastName = user.getLastName().toString(),
                email = user.getEmail().toString(),
                password = user.getPassword().toString()
            )
        )
    }

    override fun userAddedInDB(onFinishedListener: OnRegisterFinishedListener) {
        onFinishedListener.OnResultSucces()
    }

    override fun checkUserEmail(userEmail: String, context: Context): Boolean {
        usersDBHelper = DBHelper(context)
        if (usersDBHelper.checkifUserExists(userEmail)) {
            return true
        }
        return false
    }
}