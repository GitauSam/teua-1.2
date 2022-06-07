package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CreateCountyUseCaseImplTest {

    private val faker = faker {  }
    private val mockCountyPersistencePort = mock(CountyPersistencePort::class.java)
    private val subject = CreateCountyUseCaseImpl(mockCountyPersistencePort)

    @Test
    fun create_whenCountyIsCreated_returnsSavedCountry() {

        // Given
        val county = County(
            name = faker.random.randomString(7),
            status = 1
        )

        `when`(mockCountyPersistencePort.addCounty(county)).thenReturn(county.apply { id = 1 })

        // When
        val savedCounty = subject.create(county)

        // Then
        verify(mockCountyPersistencePort).addCounty(county)

        assertThat(savedCounty.id).isNotNull.isEqualTo(1L)
        assertThat(savedCounty).isEqualTo(county.apply { id = 1 })
    }
}
