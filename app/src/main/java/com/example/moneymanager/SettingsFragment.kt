package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        val button = view.findViewById<Button>(R.id.buttonAddExpense2)

        button.setOnClickListener {

            val intent = Intent(activity, FirstActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}