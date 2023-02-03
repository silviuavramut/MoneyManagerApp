package com.example.moneymanager.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.moneymanager.R
import com.example.moneymanager.model.ExpensePojo

class CustomListAdapter(private val context: Activity, private val arrayList: ArrayList<ExpensePojo>) :ArrayAdapter<ExpensePojo>(context,
    R.layout.custom_list_view,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.custom_list_view,null)

        val typeTextView : TextView = view.findViewById(R.id.textViewType)
        val accountTextView : TextView = view.findViewById(R.id.textViewAccount)
        val categoryTextView : TextView = view.findViewById(R.id.textViewCategory)
        val amountTextView : TextView = view.findViewById(R.id.textViewAmount)

        typeTextView.text = arrayList[position].getType()
        accountTextView.text = arrayList[position].getAccount()
        categoryTextView.text = arrayList[position].getCategory()
        amountTextView.text = arrayList[position].getAmount()

        return view
    }

}