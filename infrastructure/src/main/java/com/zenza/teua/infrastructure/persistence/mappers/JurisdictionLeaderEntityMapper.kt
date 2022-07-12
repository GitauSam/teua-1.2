package com.zenza.teua.infrastructure.persistence.mappers

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.infrastructure.persistence.entities.JurisdictionLeaderEntity

fun jurisdictionLeaderEntityToJurisdictionLeaderConverter(jurisdictionLeaderEntity: JurisdictionLeaderEntity): JurisdictionLeader {

    return JurisdictionLeader().apply {
        id = jurisdictionLeaderEntity.id
        leader = leaderEntitytoLeaderConverter(jurisdictionLeaderEntity.leader!!)
        jurisdictionTitle = jurisdictionTitleEntitytoJurisdictionTitleConverter(
            jurisdictionLeaderEntity.jurisdictionTitle!!)
        country = countryEntityToCountryConverter(jurisdictionLeaderEntity.country)
        county = countyEntityToCountyConverter(jurisdictionLeaderEntity.county)
        ward = wardEntityToWardConverter(jurisdictionLeaderEntity.ward)
        status = jurisdictionLeaderEntity.status
        createdAt = jurisdictionLeaderEntity.createdAt!!
        createdBy = jurisdictionLeaderEntity.createdBy!!
        modifiedAt = jurisdictionLeaderEntity.modifiedAt!!
        modifiedBy = jurisdictionLeaderEntity.modifiedBy
        deletedAt = jurisdictionLeaderEntity.deletedAt
        deletedBy = jurisdictionLeaderEntity.deletedBy
    }
}

fun jurisdictionLeaderToJurisdictionLeaderEntityConverter(jurisdictionLeader: JurisdictionLeader): JurisdictionLeaderEntity {

    return JurisdictionLeaderEntity().apply {
        id = jurisdictionLeader.id
        leader = leadertoLeaderEntityConverter(jurisdictionLeader.leader)
        jurisdictionTitle = jurisdictionTitletoJurisdictionTitleEntityConverter(jurisdictionLeader.jurisdictionTitle)
        country = countryToCountryEntityConverter(jurisdictionLeader.country)
        county = countyToCountyEntityConverter(jurisdictionLeader.county)
        ward = wardToWardEntityConverter(jurisdictionLeader.ward)
        status = jurisdictionLeader.status
        createdAt = jurisdictionLeader.createdAt
        createdBy = jurisdictionLeader.createdBy
        modifiedAt = jurisdictionLeader.modifiedAt
        modifiedBy = jurisdictionLeader.modifiedBy
        deletedAt = jurisdictionLeader.deletedAt
        deletedBy = jurisdictionLeader.deletedBy
    }
}
