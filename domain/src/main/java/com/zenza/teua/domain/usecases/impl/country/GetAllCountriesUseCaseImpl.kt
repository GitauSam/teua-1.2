package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import com.zenza.teua.domain.usecases.interfaces.country.GetAllCountriesUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetAllCountriesUseCaseImpl(
    private val countryPersistencePort: CountryPersistencePort
): GetAllCountriesUseCase {

    override fun get(): List<Country?> {
        return countryPersistencePort.getCountries()
    }
}
