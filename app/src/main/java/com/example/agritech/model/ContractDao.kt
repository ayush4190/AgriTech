package com.example.agritech.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContractDao{

    @Insert
    suspend fun addContract(contract: ContractEntity)

    @Query("select * from ContractEntity order by id asc")
    suspend fun getAllContracts():List<ContractEntity>

    @Update
    suspend fun updateContract(contract : ContractEntity)
}