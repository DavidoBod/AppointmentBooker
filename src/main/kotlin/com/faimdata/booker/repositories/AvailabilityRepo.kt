package com.faimdata.booker.repositories

import com.faimdata.booker.models.Availability
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.sql.Timestamp

interface AvailabilityRepo : JpaRepository<Availability, Long> {
    @Query("select id from Availability where provider_id = :provider and start = :start")
    fun getAvailabilityId(@Param("provider") providerId: String, @Param("start") start: Timestamp): Long?
}