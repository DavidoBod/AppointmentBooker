package com.faimdata.booker.models

import java.util.*
import javax.persistence.*

@MappedSuperclass
open class User(
        @Column var firstname: String,
        @Column var lastname: String,

        // connects to the patient_id foreign key in the appointment table
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "patient", orphanRemoval = true)
        val appointments: Set<Appointment>,

        @ManyToOne
        @JoinColumn
        val clinic: Clinic = Clinic.instance,

        @Id var id: String = firstname + lastname
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is User) {
            return false
        }

        other as User
        return firstname == other.firstname && lastname == other.lastname && id == other.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}