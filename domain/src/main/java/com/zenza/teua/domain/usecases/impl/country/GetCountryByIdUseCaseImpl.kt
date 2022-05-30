package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import com.zenza.teua.domain.usecases.interfaces.country.GetCountryByIdUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetCountryByIdUseCaseImpl(
    private val countryPersistencePort: CountryPersistencePort
): GetCountryByIdUseCase {

    override fun get(countryId: Long): Country? {
        return countryPersistencePort.getCountryById(countryId)
    }
}
