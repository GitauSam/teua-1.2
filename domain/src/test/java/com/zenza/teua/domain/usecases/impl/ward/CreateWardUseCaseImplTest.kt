package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CreateWardUseCaseImplTest {

    private val faker = faker {  }
    private val mockWardPersistencePort = mock(WardPersistencePort::class.java)
    private val subject = CreateWardUseCaseImpl(mockWardPersistencePort)

    @Test
    fun create_whenWardIsValid_returnsPersistedWard() {

        // Given
        val ward = Ward(
            name = faker.random.randomString(10),
            status = 1
        )

        `when`(mockWardPersistencePort.addWard(ward)).thenReturn(ward)

        // When
        val savedWard = subject.create(ward)

        // Then
        verify(mockWardPersistencePort).addWard(ward)

        assertThat(savedWard).isEqualTo(ward)
    }
}
