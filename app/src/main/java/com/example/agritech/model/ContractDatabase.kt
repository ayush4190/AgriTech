package com.example.agritech.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(

    entities = [ContractEntity::class],
    version = 1
)

abstract class ContractDatabase : RoomDatabase() {

    abstract fun getContractsDao() : ContractDao

    companion object{

        @Volatile private var instance : ContractDatabase? = null

        private  val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: builddatabase(context).also {
                instance = it
            }
        }


        private  fun builddatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            ContractDatabase::class.java,
            "questiondatabase"
        ).build()


    }

}