package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDateTime

internal class GetJurisdictionTitleByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockJurisdictionTitlePersistencePort = Mockito.mock(JurisdictionTitlePersistencePort::class.java)
    private val subject = GetJurisdictionTitleByIdUseCaseImpl(mockJurisdictionTitlePersistencePort)

    @Test
    fun get_whenJurisdictionTitleIsFound_returnsJurisdictionTitle() {
        // Given
        val jurisdictionTitleId = 1
        val jurisdictionTitle = JurisdictionTitle(
            title = faker.random.randomString(12),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        Mockito.`when`(mockJurisdictionTitlePersistencePort.getJurisdictionTitleById(jurisdictionTitleId))
            .thenReturn(jurisdictionTitle)

        // When
        val foundJurisdictionTitle = subject.get(jurisdictionTitleId)

        // Then
        Mockito.verify(mockJurisdictionTitlePersistencePort).getJurisdictionTitleById(jurisdictionTitleId)
        Assertions.assertThat(foundJurisdictionTitle)
            .isNotNull
            .isEqualTo(jurisdictionTitle)
    }

    @Test
    fun get_whenJurisdictionTitleIsNotFound_returnsNull() {
        // Given
        val jurisdictionTitleId = 1

        Mockito.`when`(mockJurisdictionTitlePersistencePort.getJurisdictionTitleById(jurisdictionTitleId))
            .thenReturn(null)

        // When
        val foundJurisdictionTitle = subject.get(jurisdictionTitleId)

        // Then
        Mockito.verify(mockJurisdictionTitlePersistencePort).getJurisdictionTitleById(jurisdictionTitleId)
        Assertions.assertThat(foundJurisdictionTitle)
            .isNull()
    }
}
