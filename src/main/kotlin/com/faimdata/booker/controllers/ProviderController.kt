package com.faimdata.booker.controllers

import com.faimdata.booker.models.Provider
import com.faimdata.booker.repositories.ProviderRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/providers")
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

    @PutMapping("/update/{id}")
    fun updateProvider(@PathVariable id: String, @RequestBody provider: Provider): String {
        providerRepo.deleteById(id)
        providerRepo.save(provider)
        return "Updated provider..."
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProvider(@PathVariable id: String): String {
        providerRepo.deleteById(id)
        return "Deleted provider..."
    }
}