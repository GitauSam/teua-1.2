package com.zenza.teua.infrastructure.mappers

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.infrastructure.entities.JurisdictionTitleEntity

fun jurisdictionTitletoJurisdictionTitleEntityConverter(jurisdictionTitle: JurisdictionTitle) =
    JurisdictionTitleEntity().apply {
        id = jurisdictionTitle.id
        title = jurisdictionTitle.title
        status = jurisdictionTitle.status
        createdAt = jurisdictionTitle.createdAt
        createdBy = jurisdictionTitle.createdBy
        modifiedAt = jurisdictionTitle.modifiedAt
        modifiedBy = jurisdictionTitle.modifiedBy!!
        deletedAt = jurisdictionTitle.deletedAt
        deletedBy = jurisdictionTitle.deletedBy
    }

fun jurisdictionTitleEntitytoJurisdictionTitleConverter(jurisdictionTitleEntity: JurisdictionTitleEntity) =
    JurisdictionTitle().apply {
        id = jurisdictionTitleEntity.id
        title = jurisdictionTitleEntity.title
        status = jurisdictionTitleEntity.status
        createdAt = jurisdictionTitleEntity.createdAt
        createdBy = jurisdictionTitleEntity.createdBy
        modifiedAt = jurisdictionTitleEntity.modifiedAt
        modifiedBy = jurisdictionTitleEntity.modifiedBy
        deletedAt = jurisdictionTitleEntity.deletedAt
        deletedBy = jurisdictionTitleEntity.deletedBy
    }
