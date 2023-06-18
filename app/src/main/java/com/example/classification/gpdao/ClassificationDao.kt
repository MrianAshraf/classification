package com.example.classification.gpdao

import androidx.room.*
import java.util.*

@Dao
interface ClassificationDao {

    @Insert
    fun addpatient(patient: Patientclass)

    @Update
    fun updatepatient(patient: Patientclass)

//    @Delete
//    fun deletepatient(patient: Patientclass)

    @Query("SELECT * FROM Patientclass")
    fun getallreports():List<Patientclass>

    //    @Insert
//    fun insertdoctorData(doctor:Doctorclass)

//    @Query("SELECT * FROM Doctorclass WHERE doctorusername Like :doctorusername AND doctorpassword Like:doctorpassword")
//    fun checklogin(doctorusername:String?,doctorpassword:String?): Doctorclass








}