package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.Adapter.MarkAttendanceAdapter
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.Student
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class MarkAttendance : Fragment() {
    lateinit var students: ArrayList<Student>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_mark_attendance, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.markAttendanceRecycler)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        doAsync {
            val erp = ErpViewModel(activity!!.application)
            students = ArrayList(erp.getStudents())
            onComplete {
                val adapter = MarkAttendanceAdapter(context, students)
                recycler.adapter = adapter
            }
        }
        return root
    }
}