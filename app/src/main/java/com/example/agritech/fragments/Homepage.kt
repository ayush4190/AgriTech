package com.example.agritech.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.agritech.R
import com.google.android.material.card.MaterialCardView


class Homepage : Fragment(), View.OnClickListener {


    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<MaterialCardView>(R.id.cardview_newVendor).setOnClickListener(this)
        view.findViewById<MaterialCardView>(R.id.cardview_newContracts).setOnClickListener(this)



    }


    override fun onClick(v: View?) {

        when(v!!.id)
        {
            R.id.cardview_newVendor->navController!!.navigate(R.id.action_homepage_to_vendorsfragment)

            R.id.cardview_newContracts->navController!!.navigate(R.id.action_homepage_to_newContracts)
        }

    }


}