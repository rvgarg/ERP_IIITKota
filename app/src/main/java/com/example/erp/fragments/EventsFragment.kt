package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.Adapter.EventsAdapter
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.EventObj
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class EventsFragment : Fragment() {

    lateinit var events: ArrayList<EventObj>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.eventsRecycler)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        doAsync {
            val erp = ErpViewModel(activity!!.application)
            events = ArrayList(erp.getEvents())
            onComplete {
                val adapter = EventsAdapter(context, events)
                recycler.adapter = adapter
            }
        }
        return root
    }
}