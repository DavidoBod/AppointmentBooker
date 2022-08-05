package com.faimdata.booker.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class User(
        @Column var firstname: String,
        @Column var lastname: String,
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