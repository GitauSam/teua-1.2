package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetAllJurisdictionLeadersUseCaseImplTest {

    private val mockJurisdictionLeaderPersistencePort =
        mock(JurisdictionLeaderPersistencePort::class.java)

    private val subject = GetAllJurisdictionLeadersUseCaseImpl(mockJurisdictionLeaderPersistencePort)

    @Test
    fun get_whenJurisdictionLeadersAreFound_returnsJurisdictionLeaderList() {

        // Given
        val jurisdictionLeadersList = emptyList<JurisdictionLeader>()

        `when`(mockJurisdictionLeaderPersistencePort.getAllJurisdictionLeaders())
            .thenReturn(jurisdictionLeadersList)

        // When
        val foundJurisdictionLeadersList = subject.get()

        // Then
        assertThat(foundJurisdictionLeadersList).isEqualTo(jurisdictionLeadersList)
        verify(mockJurisdictionLeaderPersistencePort).getAllJurisdictionLeaders()
    }
}
