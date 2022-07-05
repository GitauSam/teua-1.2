package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.domain.providers.JurisdictionLeaderProvider
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetJurisdictionLeaderByIdUseCaseImplTest {

    private val mockJurisdictionLeaderPersistencePort =
        mock(JurisdictionLeaderPersistencePort::class.java)

    private val subject = GetJurisdictionLeaderByIdUseCaseImpl(mockJurisdictionLeaderPersistencePort)

    @Test
    fun get_whenJurisdictionLeaderIsFound_returnsJurisdictionLeader() {

        // Given
        val jurisdictionLeaderId = 1L;
        val expectedJurisdictionLeader = JurisdictionLeaderProvider.buildJurisdictionLeader()
            .apply {
                id = 1
            }

        `when`(mockJurisdictionLeaderPersistencePort.getJurisdictionLeaderById(jurisdictionLeaderId))
            .thenReturn(expectedJurisdictionLeader)

        // When
        val foundJurisdictionLeader = subject.get(jurisdictionLeaderId)

        // Then
        assertThat(foundJurisdictionLeader).usingRecursiveComparison().isEqualTo(expectedJurisdictionLeader)
        verify(mockJurisdictionLeaderPersistencePort).getJurisdictionLeaderById(jurisdictionLeaderId)
    }

    @Test
    fun get_whenJurisdictionLeaderIsNotFound_returnsNull() {

        // Given
        val jurisdictionLeaderId = 1L;

        `when`(mockJurisdictionLeaderPersistencePort.getJurisdictionLeaderById(jurisdictionLeaderId))
            .thenReturn(null)

        // When
        val foundJurisdictionLeader = subject.get(jurisdictionLeaderId)

        // Then
        assertThat(foundJurisdictionLeader).isNull()
        verify(mockJurisdictionLeaderPersistencePort).getJurisdictionLeaderById(jurisdictionLeaderId)
    }
}
