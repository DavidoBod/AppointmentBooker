package com.faimdata.booker.models

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Provider(
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "provider", orphanRemoval = true)
        var availabilities: Set<Availability>,
        firstname: String,
        lastname: String) : User(firstname, lastname)