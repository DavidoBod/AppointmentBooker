package com.faimdata.booker.repositories

import com.faimdata.booker.models.Clinic
import org.springframework.data.jpa.repository.JpaRepository

interface ClinicRepo : JpaRepository<Clinic, String>