package com.example.agritech.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.agritech.R
import com.example.agritech.classes.Bottomsheetpullcontract
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_new_contracts.*
import kotlinx.android.synthetic.main.fragment_vendors_details.*


class VendorsDetails : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vendors_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /***
         * Currently using harcoded strings for the contract template dropdown
         */

        var existingTemplate = arrayOf("Template 1","Template 2")
        var Templateadapter = ArrayAdapter(requireContext(),R.layout.support_simple_spinner_dropdown_item,existingTemplate)
        dropdownExistingTemplate.threshold=0
        dropdownExistingTemplate.setAdapter(Templateadapter)
        dropdownExistingTemplate.setOnFocusChangeListener { view, b -> if (b) dropdownExistingTemplate.showDropDown() }

        view.findViewById<MaterialButton>(R.id.ButtonEstablishContract).setOnClickListener(this)
    }

    override fun onClick(view: View?) {


        when(view!!.id)
        {
            R.id.ButtonEstablishContract->apply {
                fragmentManager?.let {
                    Bottomsheetpullcontract().show(
                        it,
                        ""
                    )
                }
            }
        }
    }


}