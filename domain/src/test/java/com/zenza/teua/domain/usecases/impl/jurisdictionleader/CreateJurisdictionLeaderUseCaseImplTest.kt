package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.domain.providers.JurisdictionLeaderProvider
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CreateJurisdictionLeaderUseCaseImplTest {

    private val mockJurisdictionLeaderPersistencePort: JurisdictionLeaderPersistencePort =
        mock(JurisdictionLeaderPersistencePort::class.java)

    private val subject = CreateJurisdictionLeaderUseCaseImpl(mockJurisdictionLeaderPersistencePort)

    @Test
    fun create_whenProvidedValidJurisdictionLeader_createsJurisdictionLeader() {

        // Given
        val jurisdictionLeader = JurisdictionLeaderProvider.buildJurisdictionLeader()

        `when`(mockJurisdictionLeaderPersistencePort.createJurisdictionLeader(jurisdictionLeader))
            .thenReturn(jurisdictionLeader.apply { id = 1 })

        // When
        val createdJurisdictionLeader = subject.create(jurisdictionLeader)

        // Then
        assertThat(createdJurisdictionLeader.id).isEqualTo(1)
        verify(mockJurisdictionLeaderPersistencePort).createJurisdictionLeader(jurisdictionLeader)
    }
}