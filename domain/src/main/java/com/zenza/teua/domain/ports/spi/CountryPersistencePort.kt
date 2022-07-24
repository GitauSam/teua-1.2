package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.Country

interface CountryPersistencePort {

    fun createCountry(country: Country): Country

    fun getCountries(): List<Country>

    fun getCountryById(countryId: Long): Country?
}
