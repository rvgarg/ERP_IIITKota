package com.example.erp.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.EventObj
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_create_event.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete
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
            val name: String = root.findViewById<TextInputEditText>(R.id.eventName).text.toString()
            val eURL: String =
                root.findViewById<TextInputEditText>(R.id.eUrl).text.toString()
            val iURL =
                root.findViewById<TextInputEditText>(R.id.iUrl).text.toString()
            val eventDate: Long = date.time
            val eventTimes: String =
                root.findViewById<TextInputEditText>(R.id.eventTime).text.toString()
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(eventTimes) || eventDate.compareTo(0) != 0) {
//                eventName.setError("Event Name is required")
                Toast.makeText(
                    activity!!.applicationContext,
                    "Some important details are missing",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val event = EventObj(
                    name = name,
                    date = eventDate,
                    time = eventTimes,
                    URL = eURL,
                    iUrl = iURL,
                    tId = 1
                )
                doAsync {
                    val erp = ErpViewModel(activity!!.application)
                    erp.eventInsert(eventObj = event)
                    onComplete {
                        eventName.text = null
                        dateEvent.text = null
                        eUrl.text = null
                        iUrl.text = null
                        eventTime.text = null
                    }
                }
            }
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
            dp.show()
        }
        timeEvent.setEndIconOnClickListener {
            val c = Calendar.getInstance()
            val hr = c.get(Calendar.HOUR_OF_DAY)
            val mi = c.get(Calendar.MINUTE)
            val tp = TimePickerDialog(
                activity!!.applicationContext,
                TimePickerDialog.OnTimeSetListener { picker, i, i2 ->
                    eventTime.setText("" + i + " : " + i2)
                }, hr, mi, true
            )
            tp.show()

        }
        return root
    }
}