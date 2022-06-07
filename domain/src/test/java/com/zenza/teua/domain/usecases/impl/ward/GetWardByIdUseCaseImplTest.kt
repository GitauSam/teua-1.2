package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetWardByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockWardPersistencePort = mock(WardPersistencePort::class.java)
    private val subject = GetWardByIdUseCaseImpl(mockWardPersistencePort)

    @Test
    fun get_whenWardIsFound_returnsWard() {
        // Given
        val wardId = 1L
        val ward = Ward(
            id = wardId,
            name = faker.random.randomString(12),
            status = 1
        )

        `when`(mockWardPersistencePort.getWardById(wardId)).thenReturn(ward)

        // When
        val retrievedWard = subject.get(1)

        // Then
        verify(mockWardPersistencePort).getWardById(wardId)

        assertThat(retrievedWard)
            .isNotNull
            .isEqualTo(ward)
    }

    @Test
    fun get_whenWardIsNotFound_returnsNull() {
        // Given
        val wardId = 1L
        `when`(mockWardPersistencePort.getWardById(wardId)).thenReturn(null)

        // When
        val retrievedWard = subject.get(wardId)

        // Then
        assertThat(retrievedWard).isNull()
    }
}
