package com.example.agritech.fragments


import android.os.Bundle
import android.view.*
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.agritech.MainActivity
import com.example.agritech.R
import com.example.agritech.adapters.CommodityAdapter
import com.example.agritech.utils.RecylerViewClickListner
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vendorsfragment.*


class vendorsfragment : Fragment(), RecylerViewClickListner {

        private var navController:NavController? = null
        private  var recyclerView:RecyclerView? = null
        private  var adapter:CommodityAdapter?= null
        private var gridLayoutManager:GridLayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.fragment_vendorsfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        adapter = CommodityAdapter(this)
        recyclerView= view.findViewById(R.id.recyclerview_commodity)
        gridLayoutManager = GridLayoutManager(requireContext(),2,LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.searchmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCLickItemClickListner(view: View) {
        when(view.id)
        {
            R.id.carViewCommodity->navController!!.navigate(R.id.CommodityToVendor)
        }
    }


}