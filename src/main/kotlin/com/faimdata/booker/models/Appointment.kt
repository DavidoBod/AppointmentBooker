package com.faimdata.booker.models

import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Appointment(
        @ManyToOne
        @JoinColumn
        val patient: Patient,
        id: Long, start: Timestamp, end: Timestamp, provider: Provider
) : Session(id, start, end, provider) {
}