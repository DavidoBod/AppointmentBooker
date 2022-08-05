package com.faimdata.booker.repositories

import com.faimdata.booker.models.Appointment
import org.springframework.data.jpa.repository.JpaRepository

interface AppointmentRepo : JpaRepository<Appointment, Long>