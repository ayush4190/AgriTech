package com.example.agritech.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agritech.R
import com.example.agritech.adapters.CommodityAdapter
import com.example.agritech.adapters.TemplateAdapter


class SetUpTemplate : Fragment() {



    private  var recyclerView: RecyclerView? = null
    private  var adapter: TemplateAdapter?= null
    private var gridLayoutManager: GridLayoutManager?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_up_template, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TemplateAdapter()
        recyclerView= view.findViewById(R.id.recyclerViewTemplate)
        gridLayoutManager = GridLayoutManager(requireContext(),1, LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
    }


}