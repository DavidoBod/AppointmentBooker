package com.faimdata.booker.controllers

import com.faimdata.booker.models.Appointment
import com.faimdata.booker.repositories.AppointmentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appoinments")
class AppointmentController(
        @Autowired private val appointmentRepo: AppointmentRepo
) {
    @GetMapping("/")
    fun getAppointments(): List<Appointment> {
        return appointmentRepo.findAll()
    }

    @PostMapping("/save")
    fun saveAppointment(@PathVariable id: String, appointment: Appointment) {
        // TODO: does provider have this availability?
        // TODO: remove this availability from the provider
        appointmentRepo.save(appointment)
    }

    // TODO: re-add availability to provider?
    @DeleteMapping("/delete/{id}")
    fun deleteAppointment(@PathVariable id: Long) {
        appointmentRepo.deleteById(id)
    }
}