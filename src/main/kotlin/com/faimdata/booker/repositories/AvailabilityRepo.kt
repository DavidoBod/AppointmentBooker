package com.faimdata.booker.repositories

import com.faimdata.booker.models.Availability
import org.springframework.data.jpa.repository.JpaRepository

interface AvailabilityRepo : JpaRepository<Availability, Long>