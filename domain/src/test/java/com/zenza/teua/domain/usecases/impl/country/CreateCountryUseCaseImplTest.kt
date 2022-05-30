package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CreateCountryUseCaseImplTest {

    private val faker = faker {  }
    private val mockCountryPersistencePort = mock(CountryPersistencePort::class.java)
    private val subject = CreateCountryUseCaseImpl(mockCountryPersistencePort)

    @Test
    fun create_whenCountryIsCreated_returnsCountry() {
        val countryToBeSaved = Country(
            name = faker.nation.nationality(),
            status = 1
        )

        `when`(mockCountryPersistencePort.createCountry(countryToBeSaved)).thenReturn(countryToBeSaved)

        val savedCountry = subject.create(countryToBeSaved)

        verify(mockCountryPersistencePort).createCountry(countryToBeSaved)

        assertThat(countryToBeSaved == savedCountry).isTrue
    }
}