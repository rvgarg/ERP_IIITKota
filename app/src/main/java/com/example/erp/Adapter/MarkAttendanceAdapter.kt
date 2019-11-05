package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.Student

class MarkAttendanceAdapter(var context: Context?, var student: ArrayList<Student>) :
    RecyclerView.Adapter<MarkAttendanceAdapter.MarkAttendanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkAttendanceViewHolder {
        return MarkAttendanceViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.mark_attendance,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return student.size
    }

    override fun onBindViewHolder(holder: MarkAttendanceViewHolder, position: Int) {

    }

    class MarkAttendanceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}