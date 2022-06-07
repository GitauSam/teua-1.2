package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetCountyByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockCountyPersistencePort = mock(CountyPersistencePort::class.java)
    private val subject = GetCountyByIdUseCaseImpl(mockCountyPersistencePort)

    @Test
    fun get_whenCountyFound_returnsCounty() {
        // Given
        val countyId = 1L
        val county = County(
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockCountyPersistencePort.getCountyById(countyId)).thenReturn(county)

        // When
        val foundCounty = subject.get(countyId)

        // Then
        verify(mockCountyPersistencePort).getCountyById(countyId)
        assertThat(foundCounty).isNotNull
        assertThat(foundCounty).isEqualTo(county)
    }

    @Test
    fun get_whenCountyIsNotFound_returnsNull() {
        // Given
        val countyId = 1L
        `when`(mockCountyPersistencePort.getCountyById(countyId)).thenReturn(null)

        // When
        val countiesFound = subject.get(countyId)

        // Then
        verify(mockCountyPersistencePort).getCountyById(countyId)
        assertThat(countiesFound).isNull()
    }
}
