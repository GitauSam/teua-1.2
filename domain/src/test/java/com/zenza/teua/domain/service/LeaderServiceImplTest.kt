package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.usecases.interfaces.leader.CreateLeaderUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetAllLeadersUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetLeaderByIdUseCase
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDateTime

internal class LeaderServiceImplTest {

    private val faker = faker {  }
    private val mockCreateLeaderUseCase = mock(CreateLeaderUseCase::class.java)
    private val mockGetLeaderByIdUseCase = mock(GetLeaderByIdUseCase::class.java)
    private val mockGetAllLeadersUseCase = mock(GetAllLeadersUseCase::class.java)
    private val subject = LeaderServiceImpl(
        mockCreateLeaderUseCase,
        mockGetLeaderByIdUseCase,
        mockGetAllLeadersUseCase
    )

    @Test
    fun createLeader_whenLeaderIsCreated_returnsLeader() {
        // Given
        val leader = Leader(
            firstName = faker.name.firstName(),
            middleName = faker.name.nameWithMiddle(),
            lastName = faker.name.lastName(),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        `when`(mockCreateLeaderUseCase.create(leader)).thenReturn(leader)

        // When
        val createdLeader = subject.createLeader(leader)

        // Then
        verify(mockCreateLeaderUseCase).create(leader)
        assertThat(createdLeader)
            .isNotNull
            .isEqualTo(leader)
    }

    @Test
    fun getAllLeaders_whenLeadersAreFound_returnsLeadersList() {
        // Given
        val leadersList = listOf<Leader>()

        `when`(mockGetAllLeadersUseCase.get()).thenReturn(leadersList)

        // When
        val foundLeaders = subject.getLeaders()

        // Then
        verify(mockGetAllLeadersUseCase).get()

        assertThat(foundLeaders)
            .isNotNull
            .isEqualTo(leadersList)
    }

    @Test
    fun getLeaderById_whenLeadersIsFound_thenReturnsLeader() {
        // Given
        val leaderId = 1L
        val leader = Leader(
            id = 1,
            firstName = faker.name.firstName(),
            middleName = faker.name.nameWithMiddle(),
            lastName = faker.name.lastName(),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now(),
            dateOfBirth = LocalDateTime.now()
        )

        `when`(mockGetLeaderByIdUseCase.get(leaderId)).thenReturn(leader)

        // When
        val foundLeader = subject.getLeaderById(leaderId)

        // Then
        verify(mockGetLeaderByIdUseCase).get(leaderId)
        assertThat(foundLeader)
            .isNotNull
            .isEqualTo(leader)
    }

    @Test
    fun getLeaderById_whenLeadersIsNotFound_thenReturnsNull() {
        // Given
        val leaderId = 1L

        `when`(mockGetLeaderByIdUseCase.get(leaderId)).thenReturn(null)

        // When
        val foundLeader = subject.getLeaderById(leaderId)

        // Then
        verify(mockGetLeaderByIdUseCase).get(leaderId)
        assertThat(foundLeader)
            .isNull()
    }
}
