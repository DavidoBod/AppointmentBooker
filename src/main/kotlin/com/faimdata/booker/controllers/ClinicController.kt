package com.faimdata.booker.controllers

import com.faimdata.booker.models.Clinic
import com.faimdata.booker.repositories.ClinicRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clinic")
class ClinicController(
        @Autowired private val clinicRepo: ClinicRepo
) {
    @GetMapping("/")
    fun getClinic(): String {
        if (clinicRepo.findAll().isEmpty()) {
            return "Clinic has not been created yet..."
        }
        return clinicRepo.findAll()[0].toString()
    }

    /**
     * Only one clinic will be created, it will be the static clinic object specified in Clinic.kt
     */
    @PostMapping("/save")
    fun createClinic(): String {
        if (clinicRepo.findAll().isNotEmpty()) {
            return "Clinic has already been created..."
        }
        clinicRepo.save(Clinic.instance)
        return "Clinic ${Clinic.instance.name} has been created..."
    }

    /**
     * Deletes the clinic, as well as all patients, providers, availabilities, and appointments within it
     */
    @DeleteMapping("/delete")
    fun deleteClinic() {
        clinicRepo.delete(Clinic.instance)
    }
}