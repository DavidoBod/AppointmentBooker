package com.faimdata.booker.models

import javax.persistence.Entity

@Entity
class Patient(firstname: String, lastname: String, appointments: Set<Appointment>) : User(firstname, lastname, appointments)
