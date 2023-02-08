package com.example.moneymanager.model

import com.example.moneymanager.model.IUserPojo

class UserPojo : IUserPojo {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var email: String? = ""
    private var password: String? = ""

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