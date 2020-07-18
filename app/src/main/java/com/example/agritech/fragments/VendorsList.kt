package com.example.agritech.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agritech.R
import com.example.agritech.adapters.VendorListAdapter
import com.example.agritech.utils.RecylerViewClickListner


class VendorsList : Fragment(), RecylerViewClickListner {

    private  var recyclerView: RecyclerView? = null
    private  var adapter:VendorListAdapter?= null
    private var linearLayoutManager: LinearLayoutManager?= null
    private  var card: CardView?=null
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vendors_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        adapter = VendorListAdapter(this)
        recyclerView=view.findViewById(R.id.recyclerViewVendorList)
        linearLayoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
    }

    override fun onCLickItemClickListner(view: View) {
        when(view.id)
        {
            R.id.cardviewVendorList->navController!!.navigate(R.id.VendorListToDetails)
        }
    }

}