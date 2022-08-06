package com.faimdata.booker.models

import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["start", "end", "provider_id"])
])
class Availability(id: Long, start: Timestamp, end: Timestamp, provider: Provider) : Session(id, start, end, provider)