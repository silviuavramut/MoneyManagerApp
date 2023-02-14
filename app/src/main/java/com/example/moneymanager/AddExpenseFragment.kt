package com.example.moneymanager

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.moneymanager.model.ExpenseModel
import com.example.moneymanager.model.ExpensePojo
import com.example.moneymanager.presenter.ExpensePresenter
import com.example.moneymanager.view.IExpenseView
import com.google.android.material.bottomnavigation.BottomNavigationView


class AddExpenseFragment : Fragment(), IExpenseView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_add_expense, container, false)
        val dateEdt = view.findViewById<EditText>(R.id.editTextDate2)
        val sType = view.findViewById<Spinner>(R.id.spinnerType)
        val sAccount = view.findViewById<Spinner>(R.id.spinnerAccount)
        val sCategory = view.findViewById<Spinner>(R.id.spinnerCategory)
        val eAmount = view.findViewById<EditText>(R.id.editTextAmount)
        val eNote = view.findViewById<EditText>(R.id.editTextNote)
        val saveButton = view.findViewById<Button>(R.id.buttonAddExpense2)
        val bottomNav =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val expensePresenter = ExpensePresenter(this, ExpenseModel())


        saveButton.setOnClickListener {

            expensePresenter.sendExpenseInfo(
                ExpensePojo
                    (
                    sType.selectedItem.toString(),
                    dateEdt.text.toString(),
                    sAccount.selectedItem.toString(),
                    sCategory.selectedItem.toString(),
                    eAmount.text.toString(),
                    eNote.text.toString()
                ), requireContext()
            )
        }

        dateEdt.setOnClickListener {

            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting
            // our day, month and year.
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                requireContext(),
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMonth.toString() + ":" + (monthOfYear + 1) + ":" + year)
                    dateEdt.setText(dat)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        val bottomNav =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.visibility = View.VISIBLE
    }

    override fun redirect() {
        val bottomNav =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        getActivity()?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragmentLayout, ExpenseFragment())
            ?.addToBackStack(null)
            ?.commit()
        bottomNav.visibility = View.VISIBLE
    }


}