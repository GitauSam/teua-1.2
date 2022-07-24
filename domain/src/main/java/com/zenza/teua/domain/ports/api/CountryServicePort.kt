package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.Country

interface CountryServicePort {

    fun createCountry(country: Country): Country

    fun getCountries(): List<Country>

    fun getCountryById(countryId: Long): Country?
}
