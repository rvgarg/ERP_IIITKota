package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.erp.R
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.findViewById<MaterialCardView>(R.id.Announcements).setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.nav_host_fragment, AnnouncementsFragment::class.java.newInstance())
        }
        root.findViewById<MaterialCardView>(R.id.assignment).setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.nav_host_fragment, AssignmentsFragment::class.java.newInstance())
        }
        root.findViewById<MaterialCardView>(R.id.events).setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.nav_host_fragment, EventsFragment::class.java.newInstance())
        }
        root.findViewById<MaterialCardView>(R.id.professors).setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.nav_host_fragment, ProfessorsFragment::class.java.newInstance())
        }
        return root
    }
}