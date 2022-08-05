package com.faimdata.booker.controllers

import com.faimdata.booker.models.Patient
import com.faimdata.booker.repositories.PatientRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/patients")
class PatientController(
        @Autowired private val patientRepo: PatientRepo
) {
    @GetMapping("/")
    fun getPatients(): List<Patient> {
        return patientRepo.findAll()
    }

    @PostMapping("/save")
    fun savePatient(@RequestBody patient: Patient): String {
        patientRepo.save(patient)
        return "Saved patient..."
    }

    @PutMapping("/update/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody patient: Patient) {
        deletePatient(id)
        savePatient(patient)
    }

    @DeleteMapping("/delete/{id}")
    fun deletePatient(@PathVariable id: String): String {
        patientRepo.deleteById(id)
        return "Deleted patient..."
    }
}