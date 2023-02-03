package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var usersDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usersDBHelper= DBHelper(this)

        val editEmail = findViewById<EditText>(R.id.editTextEmail)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin2)


        buttonLogin.setOnClickListener {



            if (usersDBHelper!!.checkUser(editEmail.text.toString(),editPassword.text.toString())) {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                val Intent = Intent(this, NavigationActivity::class.java)
                startActivity(Intent)
                finish()
            } else {
                Toast.makeText(this, "not exist", Toast.LENGTH_LONG).show()
            }

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