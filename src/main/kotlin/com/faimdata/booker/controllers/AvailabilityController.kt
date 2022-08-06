package com.faimdata.booker.controllers

import com.faimdata.booker.models.Availability
import com.faimdata.booker.repositories.AppointmentRepo
import com.faimdata.booker.repositories.AvailabilityRepo
import org.springframework.beans.factory.annotation.Autowired
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

    @PostMapping("/save")
    fun saveAvailability(@RequestBody availability: Availability): String {
        if (appointmentRepo.containsAppointment(availability.provider.id, availability.start)) {
            return "Provider is unavailable at this time..."
        }
        availabilityRepo.save(availability)
        return "Saved availability..."
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAvailability(@PathVariable id: Long): String {
        availabilityRepo.deleteById(id)
        return "Deleting availability..."
    }
}