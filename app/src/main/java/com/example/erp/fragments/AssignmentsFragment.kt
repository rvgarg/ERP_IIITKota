package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.Adapter.AssignmentsAdapter
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.Assignments
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class AssignmentsFragment(val year: Int, val batch: String) : Fragment() {

    lateinit var assignments: ArrayList<Assignments>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_assignments, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.assignmentsRecycler)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        doAsync {
            val erp = ErpViewModel(activity!!.application)
            assignments = erp.getAssignments(year, batch)
            onComplete {
                val adapter = AssignmentsAdapter(activity!!.applicationContext, assignments)
                recycler.adapter = adapter
            }
        }
        return root
    }
}