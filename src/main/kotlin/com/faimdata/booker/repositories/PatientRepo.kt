package com.faimdata.booker.repositories

import com.faimdata.booker.models.Patient
import org.springframework.data.jpa.repository.JpaRepository

interface PatientRepo : JpaRepository<Patient, String>