package com.zenza.teua.domain.data

import java.time.LocalDateTime

data class Ward(
    var id: Long? = null,
    var name: String? = null,
    var county: County? = null,
    var status: Int? = null,
    var createdAt: LocalDateTime? = null,
    var createdBy: String? = "admin",
    var modifiedAt: LocalDateTime? = null,
    var modifiedBy: String? = "admin",
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null
)
