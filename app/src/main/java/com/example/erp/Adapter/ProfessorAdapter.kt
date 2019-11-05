package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.Professor

class ProfessorAdapter(var context: Context?, var professors: ArrayList<Professor>) :
    RecyclerView.Adapter<ProfessorAdapter.ProfessorsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorsViewHolder {
        return ProfessorsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.professor,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return professors.size
    }

    override fun onBindViewHolder(holder: ProfessorsViewHolder, position: Int) {

    }

    class ProfessorsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}