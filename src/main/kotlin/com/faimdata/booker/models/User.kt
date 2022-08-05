package com.faimdata.booker.models

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class User(
        @Column var firstname: String,
        @Column var lastname: String,
        @Id var id: String = firstname + lastname
)