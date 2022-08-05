package com.faimdata.booker.models

import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@MappedSuperclass
open class Session(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        val id: Long,
        @Column val start: Timestamp,
        @Column val end: Timestamp,

        @ManyToOne
        @JoinColumn
        val provider: Provider
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is Session) {
            return false
        }
            
        other as Session
        return id == other.id && start == other.start && end == other.end
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}