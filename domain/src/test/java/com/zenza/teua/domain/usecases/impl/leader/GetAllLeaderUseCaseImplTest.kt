package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.mockito.Mockito.*

internal class GetAllLeaderUseCaseImplTest {

    private val mockLeaderPersistencePort = mock(LeaderPersistencePort::class.java)
    private val subject = GetAllLeaderUseCaseImpl(mockLeaderPersistencePort)

    @Test
    fun get_whenLeadersAreFound_returnsLeadersList() {
        // Given
        val leaders = listOf<Leader>()

        `when`(mockLeaderPersistencePort.getLeaders())
            .thenReturn(leaders)

        // When
        val foundLeaders = subject.get()

        // Then
        verify(mockLeaderPersistencePort).getLeaders()
        assertThat(leaders).isEqualTo(foundLeaders)
    }
}
