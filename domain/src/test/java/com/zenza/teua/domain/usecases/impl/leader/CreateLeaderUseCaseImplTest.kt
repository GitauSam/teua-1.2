package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDateTime

internal class CreateLeaderUseCaseImplTest {

    private val faker = faker {  }
    private val mockLeaderPersistencePort = mock(LeaderPersistencePort::class.java)
    private val subject = CreateLeaderUseCaseImpl(mockLeaderPersistencePort)

    @Test
    fun create_whenLeaderIsCreated_returnsLeader() {
        // Given
        val leader = Leader(
            firstName = faker.name.firstName(),
            middleName = faker.name.nameWithMiddle(),
            lastName = faker.name.lastName(),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        `when`(mockLeaderPersistencePort.createLeader(leader))
            .thenReturn(leader)

        // When
        val createdLeader = subject.create(leader)

        // Then
        verify(mockLeaderPersistencePort).createLeader(leader)
        assertThat(createdLeader).isNotNull
        assertThat(leader).isEqualTo(createdLeader)
    }
}
