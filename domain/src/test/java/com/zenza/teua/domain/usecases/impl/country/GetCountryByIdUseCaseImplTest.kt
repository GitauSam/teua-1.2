package com.zenza.teua.domain.usecases.impl.country

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDateTime

internal class GetCountryByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockCountryPersistencePort = mock(CountryPersistencePort::class.java)
    private val subject = GetCountryByIdUseCaseImpl(mockCountryPersistencePort)

    @Test
    fun get_whenCountryIsFound_returnsCountry() {
        val testCountry = Country(
            id = 1,
            name = faker.nation.nationality(),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        `when`(mockCountryPersistencePort.getCountryById(1)).thenReturn(testCountry)

        val returnedCountry = subject.get(1)

        verify(mockCountryPersistencePort).getCountryById(1)

        assertThat(returnedCountry).isNotNull
        assertThat(testCountry == returnedCountry).isTrue
    }
}