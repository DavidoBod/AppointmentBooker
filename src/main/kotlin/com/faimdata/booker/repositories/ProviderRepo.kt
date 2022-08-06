package com.faimdata.booker.repositories

import com.faimdata.booker.models.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepo : JpaRepository<Provider, String>