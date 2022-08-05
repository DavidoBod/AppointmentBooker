package com.faimdata.booker.repositories

import com.faimdata.booker.models.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PatientRepo : JpaRepository<Patient, String> {
    @Query("select count(1) from Appointment where patient_id = :patient_id", nativeQuery = true)
    fun containsAppointments(@Param("patient_id") patientId: String): Boolean
}