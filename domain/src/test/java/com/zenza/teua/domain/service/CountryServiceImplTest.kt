package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.usecases.interfaces.country.CreateCountryUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetAllCountriesUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetCountryByIdUseCase
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CountryServiceImplTest {

    private val faker = faker {  }
    private val mockCreateCountryUseCase = mock(CreateCountryUseCase::class.java)
    private val mockGetCountryByIdUseCase = mock(GetCountryByIdUseCase::class.java)
    private val mockGetAllCountriesUseCase = mock(GetAllCountriesUseCase::class.java)
    private val subject = CountryServiceImpl(
        mockCreateCountryUseCase,
        mockGetCountryByIdUseCase,
        mockGetAllCountriesUseCase
    )

    @Test
    fun createCountryUseCase_whenCountryIsCreated_returnsCountry() {
        // Given
        val country = Country(
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockCreateCountryUseCase.create(country)).thenReturn(country)

        // When
        val savedCountry = subject.createCountry(country)

        // Then
        verify(mockCreateCountryUseCase).create(country)
        assertThat(savedCountry).isNotNull
        assertThat(country).isEqualTo(savedCountry)
    }

    @Test
    fun getCountryByIdUseCase_whenCountryFound_returnsCountry() {
        // Given
        val countryId = 1L
        val country = Country(
            id = 1L,
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockGetCountryByIdUseCase.get(countryId)).thenReturn(country)

        // When
        val foundCountry = subject.getCountryById(countryId)

        // Then
        verify(mockGetCountryByIdUseCase).get(countryId)
        assertThat(foundCountry).isNotNull
        assertThat(country).isEqualTo(foundCountry)
    }

    @Test
    fun getCountryByIdUseCase_whenCountryIsNotFound_returnsNull() {
        // Given
        val countryId = 1L
        `when`(mockGetCountryByIdUseCase.get(countryId)).thenReturn(null)

        // When
        val foundCountry = subject.getCountryById(countryId)

        // Then
        verify(mockGetCountryByIdUseCase).get(countryId)
        assertThat(foundCountry).isNull()
    }

    @Test
    fun getAllCountriesUseCase_whenCountriesFound_returnsCountryList() {
        // Given
        val countries = listOf<Country>()
        `when`(mockGetAllCountriesUseCase.get()).thenReturn(countries)

        // When
        val countriesFound = subject.getCountries()

        // Then
        verify(mockGetAllCountriesUseCase).get()
        assertThat(countries).isEqualTo(countriesFound)
    }
}
