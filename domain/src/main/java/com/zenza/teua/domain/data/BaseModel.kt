package com.zenza.teua.domain.data

import java.time.LocalDateTime

interface BaseModel {
    var createdAt: LocalDateTime?
    var createdBy: String?
    var modifiedAt: LocalDateTime?
    var modifiedBy: String?
    var deletedAt: LocalDateTime?
    var deletedBy: String?
}

open class DomainEntity {

    lateinit var createdAt: LocalDateTime
    lateinit var createdBy: String
    lateinit var modifiedAt: LocalDateTime
    lateinit var modifiedBy: String
    var deletedAt: LocalDateTime? = null
    var deletedBy: String? = null
}