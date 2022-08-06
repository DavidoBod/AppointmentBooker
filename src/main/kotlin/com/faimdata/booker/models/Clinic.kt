package com.faimdata.booker.models

import org.springframework.context.annotation.Scope
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@Scope("singleton")
class Clinic(
        @Id var name: String,
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "clinic", orphanRemoval = true)
        val patients: Set<Patient>,
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "clinic", orphanRemoval = true)
        val providers: Set<Provider>
) {
    companion object {
        /**
         * This instance will be the clinic that the project references throughout
         *
         * This instance must be saved in the database before any other operation
         * (since it has a bidirectional relationship with patients and providers)
         */
        val instance = Clinic("testClinic", emptySet(), emptySet())
    }
}