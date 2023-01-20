package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.presenter.LoginPresenter
import com.example.moneymanager.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editEmail = findViewById<EditText>(R.id.editTextEmail)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin2)

        val loginPresenter=LoginPresenter(this)

        buttonLogin.setOnClickListener {

            loginPresenter.doLogin(editEmail.text.toString(),editPassword.text.toString())
        }

    }

    override fun showToastMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun Redirect(){
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }
}