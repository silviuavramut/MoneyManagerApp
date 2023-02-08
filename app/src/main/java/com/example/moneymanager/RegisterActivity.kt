package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.model.RegisterModel
import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.presenter.RegisterPresenter
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.view.IRegisterView

class RegisterActivity : AppCompatActivity(), IRegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerPresenter = RegisterPresenter(this, RegisterModel())
        val editFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editLastName = findViewById<EditText>(R.id.editTextLastName)
        val editEmail = findViewById<EditText>(R.id.editTextEmail2)
        val editPassword = findViewById<EditText>(R.id.editTextPassword2)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister1)

        buttonRegister.setOnClickListener {

            if (registerPresenter.checkIfUserExists(editEmail.text.toString(), this)) {
                Toast.makeText(this, "email already used", Toast.LENGTH_LONG).show()
            } else {
                registerPresenter.sendUserInfo(
                    UserPojo(
                        editFirstName.text.toString(),
                        editLastName.text.toString(),
                        editEmail.text.toString(),
                        editPassword.text.toString()
                    ), this
                )
            }

        }
    }

    override fun redirect() {
        Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}