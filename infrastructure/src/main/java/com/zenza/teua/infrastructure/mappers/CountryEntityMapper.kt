package com.zenza.teua.infrastructure.mappers

import com.zenza.teua.domain.data.Country
import com.zenza.teua.infrastructure.entities.CountryEntity

fun countryToCountryEntityConverter(country: Country?): CountryEntity? {

    return country?.let {
                CountryEntity().apply {
                    id = country.id
                    name = country.name
                    status = country.status
                    createdAt = country.createdAt
                    createdBy = country.createdBy
                    modifiedAt = country.modifiedAt
                    modifiedBy = country.modifiedBy!!
                    deletedAt = country.deletedAt
                    deletedBy = country.deletedBy
                }
            }?: run {
                null
            }
}

fun countryEntityToCountryConverter(countryEntity: CountryEntity?): Country? {

    return countryEntity?.let {
                Country().apply {
                    id = countryEntity.id
                    name = countryEntity.name
                    status = countryEntity.status
                    createdAt = countryEntity.createdAt
                    createdBy = countryEntity.createdBy
                    modifiedAt = countryEntity.modifiedAt
                    modifiedBy = countryEntity.modifiedBy
                    deletedAt = countryEntity.deletedAt
                    deletedBy = countryEntity.deletedBy
                }
            }?: run {
                null
            }
}
