package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetAllWardsUseCaseImplTest {

    private val wardPersistencePort = mock(WardPersistencePort::class.java)
    private val subject = GetAllWardsUseCaseImpl(wardPersistencePort)
    @Test
    fun get_whenWardsFound_returnsWardsList() {

        // Given
        val wardsList = listOf <Ward>()

        `when`(subject.get()).thenReturn(wardsList)

        // When
        val wards = subject.get()

        // Then
        verify(wardPersistencePort).getWards()

        assertThat(wards).isEqualTo(wardsList)
    }
}
