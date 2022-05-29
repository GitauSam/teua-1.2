package com.zenza.teua.domain.data

import java.time.LocalDateTime

data class User(
    val id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var username: String? = null,
    var phoneNumber: String? = null,
    var password: String? = null,
    var status: Int? = null,
    var createdAt: LocalDateTime? = null,
    var createdBy: String? = "admin",
    var modifiedAt: LocalDateTime? = null,
    var modifiedBy: String? = "admin",
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null,
)
