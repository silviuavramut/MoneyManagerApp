package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.model.LoginModel
import com.example.moneymanager.model.RegisterModel
import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.presenter.LoginPresenter
import com.example.moneymanager.presenter.RegisterPresenter
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginPresenter = LoginPresenter(this, LoginModel())
        val editEmail = findViewById<EditText>(R.id.editTextEmail)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin2)


        buttonLogin.setOnClickListener {

            loginPresenter.sendUserInfoForLogin(
                UserPojo(
                    editEmail.text.toString(),
                    editPassword.text.toString()
                ), this
            )

        }

    }

    override fun Redirect() {
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
        val Intent = Intent(this, NavigationActivity::class.java)
        startActivity(Intent)
        finish()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

}