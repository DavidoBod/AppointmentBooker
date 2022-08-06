package com.faimdata.booker.controllers

import com.faimdata.booker.models.Appointment
import com.faimdata.booker.models.Availability
import com.faimdata.booker.repositories.AppointmentRepo
import com.faimdata.booker.repositories.AvailabilityRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
class AppointmentController(
        @Autowired private val appointmentRepo: AppointmentRepo,
        @Autowired private val availabilityRepo: AvailabilityRepo
) {
    @GetMapping("/")
    fun getAppointments(): List<Appointment> {
        return appointmentRepo.findAll()
    }

    @PostMapping("/save")
    fun saveAppointment(@RequestBody appointment: Appointment): String {
        val availabilityId = availabilityRepo.getAvailabilityId(appointment.provider.id, appointment.start)
                ?: return "Cannot book this appointment because the availability does not exist..."

        availabilityRepo.deleteById(availabilityId)
        appointmentRepo.save(appointment)
        return "Saved appointment..."
    }

    /**
     * Availability of the provider is recreated when the appointment is deleted
     */
    @DeleteMapping("/delete/{id}")
    fun deleteAppointment(@PathVariable id: Long) {
        val appointment = appointmentRepo.findById(id).get()
        availabilityRepo.save(Availability(appointment.id, appointment.start, appointment.end, appointment.provider))
        appointmentRepo.deleteById(id)
    }
}