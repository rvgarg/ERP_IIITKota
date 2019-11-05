package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.Adapter.AnnouncementsAdapter
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.AnnouncementObj
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class AnnouncementsFragment : Fragment() {

    lateinit var announcements: ArrayList<AnnouncementObj>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_announcements, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.announcementsRecycler)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        doAsync {
            val erp = ErpViewModel(activity!!.application)
            announcements = erp.getAnnouncements()
            onComplete {
                val adapter = AnnouncementsAdapter(context = context, ann = announcements)
                recycler.adapter = adapter
            }
        }
        return root
    }
}