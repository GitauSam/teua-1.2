package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetAllCountiesUseCaseImplTest {

    private val mockCountyPersistencePort = mock(CountyPersistencePort::class.java)
    private val subject = GetAllCountiesUseCaseImpl(mockCountyPersistencePort)

    @Test
    fun get_whenCountiesFound_returnCountiesList() {
        // Given
        val countyList = listOf<County>()
        `when`(mockCountyPersistencePort.getCounties()).thenReturn(countyList)

        // When
        val foundCounties = subject.get()

        // Then
        verify(mockCountyPersistencePort).getCounties()
        assertThat(countyList).isEqualTo(foundCounties)
    }
}
