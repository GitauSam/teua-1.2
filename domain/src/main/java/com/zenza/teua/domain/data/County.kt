package com.zenza.teua.domain.data

import lombok.Builder
import java.time.LocalDateTime

@Builder
data class County(
    var id: Long? = null,
    var name: String? = null,
    var country: Country? = null,
    var status: Int? = null,
    var createdAt: LocalDateTime? = null,
    var createdBy: String? = "admin",
    var modifiedAt: LocalDateTime? = null,
    var modifiedBy: String? = "admin",
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null
)
