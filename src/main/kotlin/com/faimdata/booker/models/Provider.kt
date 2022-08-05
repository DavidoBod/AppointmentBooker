package com.faimdata.booker.models

import javax.persistence.Entity

@Entity
class Provider(firstname: String, lastname: String) : User(firstname, lastname)