package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class GetAllJurisdictionTitlesUseCaseImplTest {

    private val mockJurisdictionTitlePersistencePort = Mockito.mock(JurisdictionTitlePersistencePort::class.java)
    private val subject = GetAllJurisdictionTitlesUseCaseImpl(mockJurisdictionTitlePersistencePort)

    @Test
    fun get_whenLeadersAreFound_returnsLeadersList() {
        // Given
        val jurisdictionTitles = listOf<JurisdictionTitle>()

        Mockito.`when`(mockJurisdictionTitlePersistencePort.getAllJurisdictionTitles())
            .thenReturn(jurisdictionTitles)

        // When
        val foundJurisdictionTitles = subject.get()

        // Then
        Mockito.verify(mockJurisdictionTitlePersistencePort).getAllJurisdictionTitles()
        Assertions.assertThat(jurisdictionTitles).isEqualTo(foundJurisdictionTitles)
    }
}
