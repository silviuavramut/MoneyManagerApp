package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.moneymanager.model.Expense
import com.example.moneymanager.model.ExpenseModel
import com.example.moneymanager.presenter.ExpensePresenter
import com.example.moneymanager.sqlite.DBHelper
import com.example.moneymanager.view.IExpenseView

class ExpenseDetailActivity : AppCompatActivity(),IExpenseView {
    private lateinit var expenseDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_detail)
        var hashMap : HashMap<String, Int> = hashMapOf("Income" to 0, "Expense" to 1,
            "Food" to 0, "Salary" to 1, "Allowance" to 2, "Culture" to 3, "Cash" to 0, "Card" to 1)

        val sType = findViewById<Spinner>(R.id.spinnerType2)
        sType.setEnabled(false)
        var sAccount = findViewById<Spinner>(R.id.spinnerAccount2)
        sAccount.setEnabled(false)
        var sCategory = findViewById<Spinner>(R.id.spinnerCategory2)
        sCategory.setEnabled(false)
        var eDate = findViewById<EditText>(R.id.editTextDate3)
        var eAmount = findViewById<EditText>(R.id.editTextAmount2)
        var eNote = findViewById<EditText>(R.id.editTextNote2)
        var saveButton = findViewById<Button>(R.id.buttonSaveExpense)
        var deleteButton = findViewById<Button>(R.id.buttonDeleteExpense)
        val expensePresenter = ExpensePresenter(this, ExpenseModel())
        expenseDBHelper= DBHelper(this)


        val id = intent.getIntExtra("id",0)
        val type = intent.getStringExtra("type")
        val date = intent.getStringExtra("date")
        val account = intent.getStringExtra("account")
        val category = intent.getStringExtra("category")
        val amount = intent.getStringExtra("amount")
        val note = intent.getStringExtra("note")
        for ((key, value) in hashMap) {
            if(type==key)
                sType.setSelection(value)
            if(account==key)
                sAccount.setSelection(value)
            if(category==key)
                sCategory.setSelection(value)
        }
        eDate.setText(date)
        eAmount.setText(amount)
        eNote.setText(note)

        deleteButton.setOnClickListener{
            expensePresenter.deleteExpense(id.toString(),this)
        }
        saveButton.setOnClickListener {
            expensePresenter.updateExpense(Expense(id = id,
                type = type.toString(),
                date = date.toString(),
                account = account.toString(),
                category = category.toString(),
                amount = amount.toString(),
                note = eNote.text.toString()),this
            )
        }


    }

    override fun redirect() {
        val i = Intent(this,NavigationActivity::class.java)
        startActivity(i)
    }
}