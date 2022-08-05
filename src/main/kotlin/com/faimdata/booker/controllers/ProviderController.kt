package com.faimdata.booker.controllers

import com.faimdata.booker.models.Provider
import com.faimdata.booker.repositories.ProviderRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/providers")
class ProviderController(
        @Autowired private val providerRepo: ProviderRepo
) {
    @GetMapping("/")
    fun getProviders(): List<Provider> {
        return providerRepo.findAll()
    }

    @PostMapping("/save")
    fun saveProvider(@RequestBody provider: Provider): String {
        providerRepo.save(provider)
        return "Saved provider..."
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProvider(@PathVariable id: String): String {
        if (providerRepo.containsAppointments(providerId = id)) {
            return "Provider cannot be deleted... has upcoming appointments"
        }
        // TODO: Should delete attached appointments
        providerRepo.deleteById(id)
        return "Deleted provider..."
    }

    // TODO: if we want to add an update function, we should also update the clinic and appointments attached to current id
}