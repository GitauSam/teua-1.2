package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDateTime

internal class GetLeaderByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockLeaderPersistencePort = mock(LeaderPersistencePort::class.java)
    private val subject = GetLeaderByIdUseCaseImpl(mockLeaderPersistencePort)

    @Test
    fun get_whenLeaderIsFound_returnsLeader() {
        // Given
        val leaderId = 1L
        val leader = Leader(
            id = 1,
            firstName = faker.name.firstName(),
            middleName = faker.name.nameWithMiddle(),
            lastName = faker.name.lastName(),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        `when`(mockLeaderPersistencePort.getLeaderById(leaderId))
            .thenReturn(leader)

        // When
        val foundLeader = subject.get(leaderId)

        // Then
        verify(mockLeaderPersistencePort).getLeaderById(leaderId)
        assertThat(foundLeader)
            .isNotNull
            .isEqualTo(leader)
    }

    @Test
    fun get_whenLeaderIsNotFound_returnsNull() {
        // Given
        val leaderId = 1L

        `when`(mockLeaderPersistencePort.getLeaderById(leaderId))
            .thenReturn(null)

        // When
        val foundLeader = subject.get(leaderId)

        // Then
        verify(mockLeaderPersistencePort).getLeaderById(leaderId)
        assertThat(foundLeader)
            .isNull()
    }
}
