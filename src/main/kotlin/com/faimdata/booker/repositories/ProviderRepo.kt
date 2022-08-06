package com.faimdata.booker.repositories

import com.faimdata.booker.models.Provider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.sql.Timestamp

interface ProviderRepo : JpaRepository<Provider, String> {
    @Query("select count(*) > 0 from Appointment where provider_id = :provider and start = :start")
    fun containsAppointment(@Param("provider") providerId: String, @Param("start") start: Timestamp): Boolean
}