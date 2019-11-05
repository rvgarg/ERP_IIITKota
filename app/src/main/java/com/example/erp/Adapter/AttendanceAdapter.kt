package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.Attendance

class AttendanceAdapter(var context: Context?, var attndance: List<Attendance>) :
    RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        return AttendanceViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.attendance,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return attndance.size
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {

    }

    class AttendanceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}