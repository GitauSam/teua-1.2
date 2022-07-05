package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDateTime

internal class CreateJurisdictionTitleUseCaseImplTest {

    private val faker = faker {  }
    private val mockJurisdictionTitlePersistencePort = Mockito.mock(JurisdictionTitlePersistencePort::class.java)
    private val subject = CreateJurisdictionTitleUseCaseImpl(mockJurisdictionTitlePersistencePort)

    @Test
    fun create_whenJurisdictionTitleIsCreated_returnsJurisdictionTitle() {
        // Given
        val jurisdictionTitle = JurisdictionTitle(
            title = faker.random.randomString(12),
            status = 1,
            createdAt = LocalDateTime.now(),
            modifiedAt = LocalDateTime.now()
        )

        Mockito.`when`(mockJurisdictionTitlePersistencePort.createJurisdictionTitle(jurisdictionTitle))
            .thenReturn(jurisdictionTitle)

        // When
        val createdJurisdictionTitle = subject.create(jurisdictionTitle)

        // Then
        Mockito.verify(mockJurisdictionTitlePersistencePort).createJurisdictionTitle(jurisdictionTitle)
        Assertions.assertThat(createdJurisdictionTitle).isNotNull
        Assertions.assertThat(jurisdictionTitle).isEqualTo(createdJurisdictionTitle)
    }
}