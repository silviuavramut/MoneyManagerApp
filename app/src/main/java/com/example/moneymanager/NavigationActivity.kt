package com.example.moneymanager

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moneymanager.view.INavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView


class NavigationActivity : AppCompatActivity(), INavigationView, BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var iNavigationView: INavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        loadFragment(ExpenseFragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.expenseFragment -> fragment = ExpenseFragment()
            R.id.statsFragment -> fragment = StatsFragment()
            R.id.accountsFragment -> fragment = AccountsFragment()
            R.id.settingsFragment2 -> fragment = SettingsFragment()
        }
        fragment?.let { loadFragment(it) }
        return true
    }

    fun loadFragment(fragment: Fragment?) {
        //to attach fragment
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout, fragment).commit()
        }
    }

    override fun setupNavBar() {


    }
    fun showToast(msg : String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }


}