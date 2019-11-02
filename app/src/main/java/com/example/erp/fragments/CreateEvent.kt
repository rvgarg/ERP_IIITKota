package com.example.erp.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.erp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_create_event.*
import java.util.*

class CreateEvent : Fragment() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    lateinit var date: Date

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_create_event, container, false)
        root.findViewById<MaterialButton>(R.id.save).setOnClickListener {
            var name = root.findViewById<TextInputEditText>(R.id.eventName).text.toString()
            var contactName = root.findViewById<TextInputEditText>(R.id.contactName).text.toString()
            var contactNumber =
                root.findViewById<TextInputEditText>(R.id.contactMobileNumber).text.toString()
                    .toLong()
            var eventDate = date.time
            
        }
        root.findViewById<TextInputLayout>(R.id.eventDate).setEndIconOnClickListener {
            val c = Calendar.getInstance()
            val Year = c.get(Calendar.YEAR)
            val Month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dp = DatePickerDialog(
                activity!!.applicationContext,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    dateEvent.setText("" + year + "/" + month + "/" + dayOfMonth)
                    date = Date(year, month, dayOfMonth)
                }, Year, Month, day
            )
        }
        return root
    }
}