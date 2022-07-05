package com.zenza.teua.domain.data

import java.time.LocalDateTime

data class Leader(
    var id: Long? = null,
    var firstName: String? = null,
    var middleName: String? = null,
    var lastName: String? = null,
    var dateOfBirth: LocalDateTime? = null,
    var status: Int? = null,
    var createdAt: LocalDateTime? = null,
    var createdBy: String? = "admin",
    var modifiedAt: LocalDateTime? = null,
    var modifiedBy: String? = "admin",
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null
)