package com.example.erp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.R
import com.example.erp.objects.EventObj

class EventsAdapter(var context: Context?, var events: List<EventObj>) :
    RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {
    override fun getItemCount(): Int {
        return events.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.events,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

    }

    class EventViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}