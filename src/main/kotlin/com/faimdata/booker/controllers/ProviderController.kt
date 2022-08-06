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

    /**
     * Provider's associated appointments and availabilities will also be deleted thanks to the cascading effect
     */
    @DeleteMapping("/delete/{id}")
    fun deleteProvider(@PathVariable id: String): String {
        if (!providerRepo.existsById(id)) {
            return "Provider does not exist..."
        }

        providerRepo.deleteById(id)
        return "Deleted provider and associated appointments..."
    }
}