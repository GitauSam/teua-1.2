package com.zenza.teua.domain.data

import java.time.LocalDateTime

data class JurisdictionTitle(
    var id: Int? = null,
    var title: String? = null,
    var status: Int? = null,
    override var createdAt: LocalDateTime? = null,
    override var createdBy: String? = "admin",
    override var modifiedAt: LocalDateTime? = null,
    override var modifiedBy: String? = "admin",
    override var deletedAt: LocalDateTime? = null,
    override var deletedBy: String? = null,
): BaseModel