package com.zenza.teua.infrastructure.persistence.mappers

import com.zenza.teua.domain.data.*
import com.zenza.teua.infrastructure.persistence.entities.CountyEntity

fun countyEntityToCountyConverter(countyEntity: CountyEntity?): County? {

    return countyEntity?.let {
                County().apply {
                    id = countyEntity.id
                    name = countyEntity.name
                    country = countryEntityToCountryConverter(countyEntity.country!!)
                    status = countyEntity.status
                    createdAt = countyEntity.createdAt
                    createdBy = countyEntity.createdBy
                    modifiedAt = countyEntity.modifiedAt
                    modifiedBy = countyEntity.modifiedBy
                    deletedAt = countyEntity.deletedAt
                    deletedBy = countyEntity.deletedBy
                }
            }?: run {
                null
            }
}

fun countyToCountyEntityConverter(county: County?): CountyEntity? {

    return county?.let {
                CountyEntity().apply {
                    id = county.id
                    name = county.name
                    country = countryToCountryEntityConverter(county.country!!)
                    status = county.status
                    createdAt = county.createdAt
                    createdBy = county.createdBy
                    modifiedAt = county.modifiedAt
                    modifiedBy = county.modifiedBy!!
                    deletedAt = county.deletedAt
                    deletedBy = county.deletedBy
                }
            }?: run {
                null
            }
}
