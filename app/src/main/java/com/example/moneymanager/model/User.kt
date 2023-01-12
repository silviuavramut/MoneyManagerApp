package com.example.moneymanager.model

class User :IUser {

    private var name : String? = ""
    private var password : String? = ""

    constructor(name: String?, password: String?) {
        this.name = name
        this.password = password
    }

    override fun getName(): String? {
        return name
    }

    override fun getPassword(): String? {
        return password
    }

    override fun checkUserValidity(name: String?, password: String?): Int {
        if (name==null||password==null||!name.equals(getName())||!password.equals(getPassword())){
            return -1;
        }
        return 0;
    }
}