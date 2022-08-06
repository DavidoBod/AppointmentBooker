package com.faimdata.booker.controllers

import com.faimdata.booker.models.Availability
import com.faimdata.booker.repositories.AppointmentRepo
import com.faimdata.booker.repositories.AvailabilityRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/availabilities")
class AvailabilityController(
        @Autowired private val availabilityRepo: AvailabilityRepo,
        @Autowired private val appointmentRepo: AppointmentRepo
) {
    @GetMapping("/")
    fun getAvailabilities(): List<Availability> {
        return availabilityRepo.findAll()
    }

    @GetMapping("/{id}")
    fun getAvailability(@PathVariable id: Long): Availability {
        return availabilityRepo.findById(id).get()
    }

    /**
     * Availability is created if the provider does not have an appointment at the time
     */
    @PostMapping("/save")
    fun saveAvailability(@RequestBody availability: Availability): String {
        val result = appointmentRepo.containsAppointment(availability.provider.id, availability.start)
        if (result) {
            return "Provider is unavailable at this time..."
        }
        try {
            availabilityRepo.save(availability)
        } catch (exception: DataIntegrityViolationException) {
            return "This provider already has this availability..."
        }

        return "Saved availability..."
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAvailability(@PathVariable id: Long): String {
        if (!availabilityRepo.existsById(id)) {
            return "Availability does not exist..."
        }
        
        availabilityRepo.deleteById(id)
        return "Deleting availability..."
    }
}