package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import com.zenza.teua.domain.usecases.interfaces.country.CreateCountryUseCase
import lombok.AllArgsConstructor
import java.time.LocalDateTime

@AllArgsConstructor
class CreateCountryUseCaseImpl(
    private val countryPersistencePort: CountryPersistencePort
): CreateCountryUseCase {

    override fun create(country: Country): Country {
        return countryPersistencePort.createCountry(
            country.apply {
                status = 1
                createdAt = LocalDateTime.now()
                createdBy = "admin"
                modifiedAt = LocalDateTime.now()
                modifiedBy = "admin"
            }
        )
    }
}
