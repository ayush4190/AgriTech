package com.example.agritech.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.agritech.R
import com.example.agritech.model.ContractDatabase
import com.example.agritech.model.ContractEntity
import com.example.agritech.utils.BaseFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_new_contracts.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import java.util.*
import kotlinx.coroutines.launch

import kotlinx.coroutines.launch
import javax.xml.datatype.DatatypeConstants.MONTHS


class NewContracts : BaseFragment(){


    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contracts, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = Navigation.findNavController(view)
        /**
         * Below is the autocomplete text view parameters for the contractType
         */
        var contracttype = arrayOf("Sales", "Purchase")
        var adapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            contracttype
        )
        dropdownContracts.threshold = 0;
        dropdownContracts.setAdapter(adapter)
        dropdownContracts.setOnFocusChangeListener { view, b -> if (b) dropdownContracts.showDropDown() }

        /**
         *Side
         */

        var side = arrayOf("Side1", "Side2")
        var sideadapter =
            ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, side)
        dropdownSide.threshold = 0
        dropdownSide.setAdapter(sideadapter)
        dropdownSide.setOnFocusChangeListener { view, b -> if (b) dropdownSide.showDropDown() }

        /**
         * Incoterm
         */
        var Incoterm = arrayOf("Incoterm1", "Incoterm2")
        var Incoternmadapter =
            ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, Incoterm)
        dropdownIncoterm.threshold = 0
        dropdownIncoterm.setAdapter(Incoternmadapter)
        dropdownIncoterm.setOnFocusChangeListener { view, b -> if (b) dropdownIncoterm.showDropDown() }

        /**
         * ToleranceId
         */

        var threshholdId = arrayOf("ID1", "ID2")
        var threshholdIDadapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            threshholdId
        )
        dropdownToleranceScheduleId.threshold = 0
        dropdownToleranceScheduleId.setAdapter(threshholdIDadapter)
        dropdownToleranceScheduleId.setOnFocusChangeListener { view, b -> if (b) dropdownToleranceScheduleId.showDropDown() }
        /**
         * Tolerance Type
         */

        var tolerancetype = arrayOf("Tolerance 1", "Tolerance2")
        var toladapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            tolerancetype
        )
        dropdownToleranceType.threshold = 0
        dropdownToleranceType.setAdapter(toladapter)
        dropdownToleranceType.setOnFocusChangeListener { view, b -> if (b) dropdownToleranceType.showDropDown() }


        /**
         *DPQS Schedule
         */

        var DPQS = arrayOf("DPQS1", "DPQS2")
        var dpqsadapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, DPQS)
        dropdownDPQSSchedule.threshold = 0
        dropdownDPQSSchedule.setAdapter(dpqsadapter)
        dropdownDPQSSchedule.setOnFocusChangeListener { view, b -> if (b) dropdownDPQSSchedule.showDropDown() }




        view.findViewById<TextInputEditText>(R.id.startdate).setOnClickListener {
            startopenCalender()
        }
        view.findViewById<TextInputEditText>(R.id.enddate).setOnClickListener {
            endopenCalender()
        }

        view.findViewById<MaterialButton>(R.id.PublishContract).setOnClickListener {

            if(dropdownContracts.text.isNullOrBlank())
            {
                dropdownContracts.error = "Required"
                return@setOnClickListener
            }

            if(dropdownSide.text.isNullOrEmpty())
            {
                dropdownSide.error = "Required"
                return@setOnClickListener
            }
            if(dropdownIncoterm.text.isNullOrEmpty())
            {
                dropdownIncoterm.error = "Required"
                return@setOnClickListener
            }
            if(editTextMaterial.text.toString().isNullOrEmpty())
            {
                editTextMaterial.error = "Required"
                return@setOnClickListener
            }
            if(editTextPlant.text.isNullOrEmpty())
            {
                editTextPlant.error = "Required"
                return@setOnClickListener
            }

            if(editTextQuantity.text.isNullOrEmpty())
            {
                editTextQuantity.error="Required"
                return@setOnClickListener
            }
            if(dropdownToleranceScheduleId.text.isNullOrEmpty())
            {
                dropdownToleranceScheduleId.error = "Required"
                return@setOnClickListener
            }
            if(dropdownToleranceType.text.isNullOrEmpty())
            {
                dropdownToleranceType.error = "Required"
                return@setOnClickListener
            }
            if(dropdownDPQSSchedule.text.isNullOrEmpty())
            {
                dropdownDPQSSchedule.error = "Required"
                return@setOnClickListener
            }
            if(startdate.text.isNullOrEmpty())
            {
                startdate.error = "Required"
                return@setOnClickListener
            }
            if(enddate.text.isNullOrEmpty())
            {
                dropdownSide.error = "Required"
                return@setOnClickListener
            }





            launch{

                val contractEntity= ContractEntity(dropdownContracts.text.toString(),dropdownSide.text.toString(),dropdownIncoterm.text.toString(),
                editTextMaterial.text.toString(),editTextPlant.text.toString(),editTextQuantity.text.toString(),
                dropdownToleranceScheduleId.text.toString(), dropdownToleranceType.text.toString(),dropdownDPQSSchedule.text.toString(),
                startdate.text.toString(),enddate.text.toString())
                context?.let {
                    ContractDatabase(it).getContractsDao().addContract(contractEntity)
                    Toast.makeText(requireContext(), "Contract saved as a template", Toast.LENGTH_SHORT).show()
                    navController!!.navigate(R.id.NewContractToHomepage)

                }
            }



        }
    }

    private fun endopenCalender() {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->


                /**TODO Set Date from the date picker to the start and end date **/

                enddate.setText("$dayOfMonth/$monthOfYear/$year")

            },
            year,
            month,
            day
        )

        dpd.show()
    }


    private fun startopenCalender() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd =
            DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->


                /**TODO Set Date from the date picker to the start and end date **/

                startdate.setText("$dayOfMonth/$monthOfYear/$year")

            }, year, month, day)

        dpd.show()
    }

}

