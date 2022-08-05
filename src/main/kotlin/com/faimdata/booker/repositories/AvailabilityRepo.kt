package com.faimdata.booker.repositories

import com.faimdata.booker.models.Availability
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AvailabilityRepo : JpaRepository<Availability, Long> {

    @Query("select * from Availabilities a where a.provider_id = :provider_id")
    fun getProviderAvailabilities(@Param("provider_id") providerId: String): List<Availability>
}