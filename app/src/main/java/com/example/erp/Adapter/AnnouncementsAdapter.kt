package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.AnnouncementObj

class AnnouncementsAdapter(var context: Context?, var ann: ArrayList<AnnouncementObj>) :
    RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementsViewHolder {
        return AnnouncementsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.announcement,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return ann.size
    }

    override fun onBindViewHolder(holder: AnnouncementsViewHolder, position: Int) {

    }

    class AnnouncementsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}