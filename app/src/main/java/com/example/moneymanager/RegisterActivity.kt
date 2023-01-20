package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.presenter.LoginPresenter
import com.example.moneymanager.presenter.RegisterPresenter
import com.example.moneymanager.view.IRegisterView

class RegisterActivity : AppCompatActivity(), IRegisterView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editLastName = findViewById<EditText>(R.id.editTextLastName)
        val editEmail = findViewById<EditText>(R.id.editTextEmail2)
        val editPassword = findViewById<EditText>(R.id.editTextPassword2)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister1)

        val registerPresenter= RegisterPresenter(this)

        buttonRegister.setOnClickListener {

            registerPresenter.doRegister(editFirstName.text.toString(),editLastName.text.toString(),editEmail.text.toString(),editPassword.text.toString())
        }
    }

    override fun showToastMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
    override fun Redirect(){
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }
}