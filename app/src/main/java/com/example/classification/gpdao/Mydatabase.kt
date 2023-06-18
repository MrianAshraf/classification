package com.example.classification.gpdao

import android.content.Context
import androidx.room.*
import androidx.room.RoomDatabase


@Database(entities = [Patientclass::class], version = 1)

abstract class Mydatabase :RoomDatabase(){

    abstract fun gpreportdao():ClassificationDao

    companion object{

        val DatabaseName ="Report-Database";
       private var mydatabase:Mydatabase?=null;
        fun getinstance(context:Context):Mydatabase{
            if(mydatabase==null){
           mydatabase= Room.databaseBuilder(context,Mydatabase::class.java, DatabaseName)
               .fallbackToDestructiveMigration()
               .allowMainThreadQueries()
               .build()
        }
        return mydatabase!!;
    }


}}


