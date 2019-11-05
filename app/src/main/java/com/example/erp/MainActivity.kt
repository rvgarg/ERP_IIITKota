package com.example.erp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {
    private lateinit var Role: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener {
            val user = loginId.text.toString()
            val pass = loginPass.text.toString()
            error.text = ""
            doAsync {
                val erpViewModel = ErpViewModel(application)
                when (Role) {
                    "Staff" -> {
                        val lg = erpViewModel.loginTeacher(user, pass)
                        runOnUiThread {
                            if (lg.name.isEmpty()) {
                                error.text = "Invalid Credentials!!"
                            } else {
                                startActivity(
                                    Intent(
                                        application,
                                        ProfessorActivity::class.java
                                    )
                                )
                                finish()
                            }
                        }
                    }
                    "Student" -> {
                        val lg = erpViewModel.loginStudent(user, pass)
                        runOnUiThread {
                            if (lg.name.isEmpty()) {
                                error.text = "Invalid Credentials!!"
                            } else {
                                startActivity(
                                    Intent(
                                        application,
                                        StudentActivity::class.java
                                    )
                                )
                                finish()
                            }
                        }
                    }
                }
            }
        }
        register.setOnClickListener {
            when (Role) {
                "Staff" -> {
                    startActivity(
                        Intent(
                            application,
                            ProfessorRegActivity::class.java
                        )
                    )
                }
                "Student" -> {
                    startActivity(
                        Intent(
                            application,
                            StudentRegActivity::class.java
                        )
                    )
                }
            }
        }
        staff.setOnClickListener {
            Role = "Staff"
            lg_img.setImageResource(R.drawable.professor)
            choice.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }
        student.setOnClickListener {
            Role = "Student"
            lg_img.setImageResource(R.drawable.student)
            choice.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }
    }
}