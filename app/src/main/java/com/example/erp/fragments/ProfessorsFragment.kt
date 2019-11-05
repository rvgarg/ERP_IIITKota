package com.example.erp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erp.Adapter.ProfessorAdapter
import com.example.erp.ErpViewModel
import com.example.erp.R
import com.example.erp.objects.Professor
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete

class ProfessorsFragment : Fragment() {

    lateinit var professors: ArrayList<Professor>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_professors, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.professorsRecycler)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = layoutManager
        doAsync {
            val erp = ErpViewModel(activity!!.application)
            professors = erp.getTeachers()
            onComplete {
                val adapter = ProfessorAdapter(context, professors)
                recycler.adapter = adapter
            }
        }
        return root
    }
}