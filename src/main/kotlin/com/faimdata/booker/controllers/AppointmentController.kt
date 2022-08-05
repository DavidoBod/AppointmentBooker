package com.faimdata.booker.controllers

import com.faimdata.booker.models.Appointment
import com.faimdata.booker.repositories.AppointmentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/appoinments")
class AppointmentController(
        @Autowired private val appointmentRepo: AppointmentRepo
) {
    @GetMapping("/")
    fun getAppointments(): List<Appointment> {
        return appointmentRepo.findAll()
    }
}