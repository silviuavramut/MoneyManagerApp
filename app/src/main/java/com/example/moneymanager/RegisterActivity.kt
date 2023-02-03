package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.model.User
import com.example.moneymanager.model.UserPojo
import com.example.moneymanager.presenter.RegisterPresenter
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.view.IRegisterView

class RegisterActivity : AppCompatActivity(), IRegisterView {
    lateinit var usersDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usersDBHelper= DBHelper(this)
        val editFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editLastName = findViewById<EditText>(R.id.editTextLastName)
        val editEmail = findViewById<EditText>(R.id.editTextEmail2)
        val editPassword = findViewById<EditText>(R.id.editTextPassword2)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister1)


        buttonRegister.setOnClickListener {

            if(usersDBHelper.checkifUserExists(editEmail.text.toString())){
                Toast.makeText(this, "email already used", Toast.LENGTH_LONG).show()
            }
            else {

                var result = usersDBHelper.insertUser(
                    User(
                        firstName = editFirstName.text.toString(),
                        lastName = editLastName.text.toString(),
                        email = editEmail.text.toString(),
                        password = editPassword.text.toString()
                    )
                )
                Toast.makeText(this, "succes", Toast.LENGTH_LONG).show()
                val Intent = Intent(this, LoginActivity::class.java)
                startActivity(Intent)
                finish()
            }

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