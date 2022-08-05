package com.faimdata.booker.controllers

import com.faimdata.booker.models.Availability
import com.faimdata.booker.repositories.AvailabilityRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/availabilities")
class AvailabilityController(
        @Autowired private val availabilityRepo: AvailabilityRepo
) {
    @GetMapping("/")
    fun getAvailabilities(): List<Availability> {
        return availabilityRepo.findAll()
    }

    @PostMapping("/save")
    fun saveAvailability(@RequestBody availability: Availability): String {
        availabilityRepo.save(availability)
        return "Saved availability..."
    }

    @DeleteMapping("/delete/{id}")
    fun deleteAvailability(@PathVariable id: Long): String {
        availabilityRepo.deleteById(id)
        return "Deleting availability..."
    }
}