package com.faimdata.booker.models

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Provider(
        // connects to the provider foreign key in the availability table
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "provider", orphanRemoval = true)
        val availabilities: Set<Availability>,
        firstname: String,
        lastname: String,
        appointments: Set<Appointment>)
    : User(firstname, lastname, appointments)