package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.api.CountryServicePort
import com.zenza.teua.domain.usecases.interfaces.country.CreateCountryUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetAllCountriesUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetCountryByIdUseCase

class CountryServiceImpl(
   private val createCountryUseCase: CreateCountryUseCase,
   private val getCountryByIdUseCase: GetCountryByIdUseCase,
   private val getAllCountriesUseCase: GetAllCountriesUseCase
): CountryServicePort{

    override fun createCountry(country: Country): Country {
        return createCountryUseCase.create(country)
    }

    override fun getCountries(): List<Country> {
        return getAllCountriesUseCase.get()
    }

    override fun getCountryById(countryId: Long): Country? {
        return getCountryByIdUseCase.get(countryId)
    }
}
