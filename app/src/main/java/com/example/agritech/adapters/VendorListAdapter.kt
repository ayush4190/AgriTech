package com.example.agritech.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agritech.R
import com.example.agritech.fragments.VendorsList
import com.example.agritech.utils.RecylerViewClickListner
import kotlinx.android.synthetic.main.cardviewlistview.view.*

class VendorListAdapter (private var listner: RecylerViewClickListner): RecyclerView.Adapter<VendorListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardviewlistview,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.cardviewVendorList.setOnClickListener {
            listner.onCLickItemClickListner(it)
            }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}