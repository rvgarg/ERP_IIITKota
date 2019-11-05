package com.example.erp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.erp.objects.Professor
import kotlinx.android.synthetic.main.activity_professor_reg.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class ProfessorRegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professor_reg)
        val Branch = branch.text.toString()
        val Name = name.text.toString()
        val Id = userName.text.toString()
        val Email = email.text.toString()
        val Password = password.text.toString()
        val ConfPass = cnfPassword.text.toString()
        val Number = number.text.toString().toLong()
        val JoiningDate = joiningDate.text.toString()
        var ready = true
        var pReady = true
        if (TextUtils.isEmpty(Name)) {
            ready = false
            name.error = "Required!"
        }
        if (TextUtils.isEmpty(Id)) {
            ready = false
            userName.error = "Required!"
        }
        if (TextUtils.isEmpty(Email)) {
            ready = false
            email.error = "Required!"
        }
        if (TextUtils.isEmpty(Password)) {
            ready = false
            pReady = false
            password.error = "Required!"
        }
        if (TextUtils.isEmpty(ConfPass)) {
            ready = false
            pReady = false
            cnfPassword.error = "Required!"
        }
        if (TextUtils.isEmpty(Branch)) {
            ready = false
            branch.error = "Required!"
        }
        if (TextUtils.isEmpty(number.text.toString())) {
            ready = false
            number.error = "Required!"
        }
        if (TextUtils.isEmpty(JoiningDate)) {
            ready = false
            joiningDate.error = "Required!"
        }
        if (pReady) {
            if (Password != ConfPass) {
                cnfPassword.error = "password and confirm password must be same!!"
                password.error = "password and confirm password must be same!!"
                ready = false
            }
        }
        if (ready) {
            val professor = Professor(
                name = Name,
                mobileNumber = Number,
                branchId = Branch,
                joiningDate = JoiningDate,
                emailId = Email,
                username = Id,
                password = Password
            )
            doAsync {
                val erp = ErpViewModel(application)
                erp.teacherInsert(professor)
                onComplete {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}