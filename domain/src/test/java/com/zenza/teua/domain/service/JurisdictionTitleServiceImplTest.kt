package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.CreateJurisdictionTitleUseCase
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetAllJurisdictionTitlesUseCase
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetJurisdictionTitleByIdUseCase
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDateTime

internal class JurisdictionTitleServiceImplTest {

    private val faker = faker {  }
    private val mockCreateJurisdictionTitleUseCase = Mockito.mock(CreateJurisdictionTitleUseCase::class.java)
    private val mockGetJurisdictionTitleByIdUseCase = Mockito.mock(GetJurisdictionTitleByIdUseCase::class.java)
    private val mockGetAllJurisdictionTitlesUseCase = Mockito.mock(GetAllJurisdictionTitlesUseCase::class.java)
    private val subject = JurisdictionTitleServiceImpl(
        mockCreateJurisdictionTitleUseCase,
        mockGetJurisdictionTitleByIdUseCase,
        mockGetAllJurisdictionTitlesUseCase
    )

    @Test
    fun createLeader_whenJurisdictionTitleIsCreated_returnsLeader() {
        // Given
        val jurisdictionTitle = JurisdictionTitle(
            title = faker.random.randomString(12),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        Mockito.`when`(mockCreateJurisdictionTitleUseCase.create(jurisdictionTitle))
            .thenReturn(jurisdictionTitle)

        // When
        val createdJurisdictionTitle = subject.createJurisdictionTitle(jurisdictionTitle)

        // Then
        Mockito.verify(mockCreateJurisdictionTitleUseCase).create(jurisdictionTitle)
        Assertions.assertThat(createdJurisdictionTitle)
            .isNotNull
            .isEqualTo(jurisdictionTitle)
    }

    @Test
    fun getAllJurisdictionTitles_whenJurisdictionTitlesAreFound_returnsJurisdictionTitlesList() {
        // Given
        val jurisdictionTitlesList = listOf<JurisdictionTitle>()

        Mockito.`when`(mockGetAllJurisdictionTitlesUseCase.get()).thenReturn(jurisdictionTitlesList)

        // When
        val foundJurisdictionTitles = subject.getAllJurisdictionTitles()

        // Then
        Mockito.verify(mockGetAllJurisdictionTitlesUseCase).get()

        Assertions.assertThat(foundJurisdictionTitles)
            .isNotNull
            .isEqualTo(jurisdictionTitlesList)
    }

    @Test
    fun getJurisdictionTitleById_whenJurisdictionTitleIsFound_thenReturnsJurisdictionTitle() {
        // Given
        val jurisdictionTitleId = 1
        val jurisdictionTitle = JurisdictionTitle(
            id = 1,
            title = faker.random.randomString(12),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now(),
        )

        Mockito.`when`(mockGetJurisdictionTitleByIdUseCase.get(jurisdictionTitleId))
            .thenReturn(jurisdictionTitle)

        // When
        val foundJurisdictionTitle = subject.getJurisdictionTitleById(jurisdictionTitleId)

        // Then
        Mockito.verify(mockGetJurisdictionTitleByIdUseCase).get(jurisdictionTitleId)
        Assertions.assertThat(foundJurisdictionTitle)
            .isNotNull
            .isEqualTo(jurisdictionTitle)
    }

    @Test
    fun getJurisdictionTitleById_whenJurisdictionTitleIsNotFound_thenReturnsNull() {
        // Given
        val jurisdictionTitleId = 1

        Mockito.`when`(mockGetJurisdictionTitleByIdUseCase.get(jurisdictionTitleId)).thenReturn(null)

        // When
        val foundJurisdictionTitle = subject.getJurisdictionTitleById(jurisdictionTitleId)

        // Then
        Mockito.verify(mockGetJurisdictionTitleByIdUseCase).get(jurisdictionTitleId)
        Assertions.assertThat(foundJurisdictionTitle)
            .isNull()
    }
}
