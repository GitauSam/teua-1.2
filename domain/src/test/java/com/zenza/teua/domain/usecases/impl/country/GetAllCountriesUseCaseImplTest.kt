package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetAllCountriesUseCaseImplTest {

    private val mockCountryPersistencePort = mock(CountryPersistencePort::class.java)
    private val subject = GetAllCountriesUseCaseImpl(mockCountryPersistencePort)

    @Test
    fun get_whenCountriesFound_returnsCountriesList() {
        val countriesList = emptyList<Country>()

        `when`(mockCountryPersistencePort.getCountries()).thenReturn(countriesList)

        val countriesListFound = subject.get()

        verify(mockCountryPersistencePort).getCountries()

        assertThat(countriesList == countriesListFound).isTrue
    }
}