package com.example.erp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.erp.objects.Student
import kotlinx.android.synthetic.main.activity_student_reg.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class StudentRegActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_reg)
        save.setOnClickListener {
            val Name = name.text.toString()
            val Id = studentId.text.toString()
            val Email = email.text.toString()
            val Password = password.text.toString()
            val ConfPass = cnfPassword.text.toString()

            val Branch = branch.text.toString()
            val Batch = batch.text.toString()

            var ready = true
            var pReady = true
            if (TextUtils.isEmpty(Name)) {
                ready = false
                name.error = "Required!"
            }
            if (TextUtils.isEmpty(Id)) {
                ready = false
                studentId.error = "Required!"
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
            if (TextUtils.isEmpty(Batch)) {
                ready = false
                batch.error = "Required!"
            }
            if (TextUtils.isEmpty(Branch)) {
                ready = false
                branch.error = "Required!"
            }
            if (TextUtils.isEmpty(number.text.toString())) {
                ready = false
                number.error = "Required!"
            }
            if (TextUtils.isEmpty(year.text.toString())) {
                ready = false
                year.error = "Required!"
            }
            if (TextUtils.isEmpty(age.text.toString())) {
                age.error = "Required!"
                ready = false
            }
            if (pReady) {
                if (Password != ConfPass) {
                    cnfPassword.error = "password and confirm password must be same!!"
                    password.error = "password and confirm password must be same!!"
                    ready = false
                }
            }
            if (ready) {
                val Age = age.text.toString().toInt()
                val Number = number.text.toString().toLong()
                val Year = year.text.toString().toInt()
                val student = Student(
                    studentId = Id,
                    name = Name,
                    mobile = Number,
                    year = Year,
                    pass = Password,
                    batch = Batch,
                    branch = Branch,
                    age = Age,
                    email = Email
                )
                doAsync {
                    val erp = ErpViewModel(application)
                    erp.studentInsert(student)
                    onComplete {
                        startActivity(Intent(application, MainActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }
}
