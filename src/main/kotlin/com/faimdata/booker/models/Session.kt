package com.faimdata.booker.models

import java.sql.Timestamp
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
)