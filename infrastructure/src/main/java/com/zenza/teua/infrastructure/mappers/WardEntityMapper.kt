package com.zenza.teua.infrastructure.mappers

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.infrastructure.entities.WardEntity

fun wardToWardEntityConverter(ward: Ward?): WardEntity? {

    return ward?.let {
                WardEntity().apply {
                    id = ward.id
                    name = ward.name
                    county = countyToCountyEntityConverter(ward.county!!)
                    status = ward.status
                    createdAt = ward.createdAt
                    createdBy = ward.createdBy
                    modifiedAt = ward.modifiedAt
                    modifiedBy = ward.modifiedBy!!
                    deletedAt = ward.deletedAt
                    deletedBy = ward.deletedBy
                }
            }?: run {
                null
            }
}

fun wardEntityToWardConverter(wardEntity: WardEntity?): Ward? {

    return wardEntity?.let {
                Ward().apply {
                    id = wardEntity.id
                    name = wardEntity.name
                    county = countyEntityToCountyConverter(wardEntity.county!!)
                    status = wardEntity.status
                    createdAt = wardEntity.createdAt
                    createdBy = wardEntity.createdBy
                    modifiedAt = wardEntity.modifiedAt
                    modifiedBy = wardEntity.modifiedBy
                    deletedAt = wardEntity.deletedAt
                    deletedBy = wardEntity.deletedBy
                }
            }?: run {
                null
            }
}
