package com.faimdata.booker.models

import java.sql.Timestamp
import javax.persistence.Entity

@Entity
class Availability(id: Long, start: Timestamp, end: Timestamp, provider: Provider) : Session(id, start, end, provider)