package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.Country
import com.zenza.teua.infrastructure.persistence.mappers.countryToCountryEntityConverter
import com.zenza.teua.infrastructure.persistence.adapters.CountryEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.CountryEntityRepository
import io.github.serpro69.kfaker.faker
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDateTime

internal class CountryEntityJpaAdapterTest {

    private val mockCountryEntityRepository = mock(CountryEntityRepository::class.java)

    private val subject = CountryEntityJpaAdapter(mockCountryEntityRepository)

    private val faker = faker {  }

    @Test
    fun createCountry_whenCountryIsValid_returnsPersistedCountry() {
        val country = Country().apply {
            name = faker.random.randomString(12)
            status = 1
            createdAt = LocalDateTime.now()
            createdBy = faker.name.name()
            modifiedAt = LocalDateTime.now()
            modifiedBy = faker.name.name()
        }

        val expectedCountryEntity = countryToCountryEntityConverter(country)

        `when`(mockCountryEntityRepository.save(any()))
            .thenReturn(expectedCountryEntity)

        val persistedCountyEntity = mockCountryEntityRepository.save(expectedCountryEntity)

        verify(mockCountryEntityRepository).save(expectedCountryEntity)
    }
}