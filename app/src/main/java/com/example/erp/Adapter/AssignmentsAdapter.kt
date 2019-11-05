package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.Assignments

class AssignmentsAdapter(var context: Context?, var assignments: ArrayList<Assignments>) :
    RecyclerView.Adapter<AssignmentsAdapter.AssignmentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentsViewHolder {
        return AssignmentsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.assignments,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return assignments.size
    }

    override fun onBindViewHolder(holder: AssignmentsViewHolder, position: Int) {

    }

    class AssignmentsViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }
}