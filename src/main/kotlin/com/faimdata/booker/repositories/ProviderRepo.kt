package com.faimdata.booker.repositories

import com.faimdata.booker.models.Provider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProviderRepo : JpaRepository<Provider, String> {
    @Query("select count(1) from Appointment where provider_id = :provider_id", nativeQuery = true)
    fun containsAppointments(@Param("provider_id") providerId: String): Boolean
}