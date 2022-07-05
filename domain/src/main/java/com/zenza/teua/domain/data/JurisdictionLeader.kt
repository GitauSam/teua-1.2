package com.zenza.teua.domain.data

import lombok.Builder

@Builder
class JurisdictionLeader: DomainEntity() {

    var id: Long? = null
    lateinit var leader: Leader
    lateinit var jurisdictionTitle: JurisdictionTitle
    var country: Country? = null
    var county: County? = null
    var ward: Ward? = null
    var status: Int? = null
}
