package com.example.agritech.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agritech.R
import com.example.agritech.utils.RecylerViewClickListner
import kotlinx.android.synthetic.main.gridlayout.view.*

class CommodityAdapter(private val  listner: RecylerViewClickListner):RecyclerView.Adapter<CommodityAdapter.ViewHolder>() {








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.gridlayout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.carViewCommodity.setOnClickListener{
            listner.onCLickItemClickListner(it)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}
