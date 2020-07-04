package com.example.agritech.fragments


import android.os.Bundle
import android.view.*
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.agritech.MainActivity
import com.example.agritech.R
import com.example.agritech.adapters.CommodityAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vendorsfragment.*


class vendorsfragment : Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview_commodity)
        recyclerView?.layoutManager=LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
        val adapter = CommodityAdapter()
        recyclerView?.adapter= adapter




        return inflater.inflate(R.layout.fragment_vendorsfragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.searchmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}