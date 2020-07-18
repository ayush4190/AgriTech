package com.example.agritech.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContractEntity(

    var ContractType: String? = null,
    var Side : String? = null,
    var Incoterm: String? = null,
    var Material : String? = null,
    var Plant : String? = null,
    var Qualtity : String? = null,
    var ToleranceScheduleId: String? = null,
    var ToleranceID:String? = null,
    var DPQS: String? = null,
    var StartDate: String? = null,
    var enddate : String? = null

){

    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}