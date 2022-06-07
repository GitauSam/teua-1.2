package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.usecases.interfaces.county.CreateCountyUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetAllCountiesUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetCountyByIdUseCase
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CountyServiceImplTest {

    private val faker = faker {  }
    private val mockCreateCountyUseCase = mock(CreateCountyUseCase::class.java)
    private val mockGetAllCountiesUseCase = mock(GetAllCountiesUseCase::class.java)
    private val mockGetCountyByIdUseCase = mock(GetCountyByIdUseCase::class.java)
    private val subject = CountyServiceImpl(
        mockCreateCountyUseCase,
        mockGetCountyByIdUseCase,
        mockGetAllCountiesUseCase
    )

    @Test
    fun createCountyUseCase_whenCountyIsCreated_returnsCounty() {
        // Given
        val county = County(
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockCreateCountyUseCase.create(county)).thenReturn(county)

        // When
        val createdCounty = subject.createCounty(county)

        // Then
        verify(mockCreateCountyUseCase).create(county)
        assertThat(createdCounty).isNotNull
        assertThat(county).isEqualTo(createdCounty)
    }

    @Test
    fun getCountyByIdUseCase_whenCountyIsFound_returnsCounty() {
        // Given
        val countyId = 1L
        val county = County(
            id = 1L,
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockGetCountyByIdUseCase.get(countyId)).thenReturn(county)

        // When
        val foundCounty = subject.getCountyById(countyId)

        // Then
        verify(mockGetCountyByIdUseCase).get(countyId)
        assertThat(foundCounty).isNotNull
        assertThat(county).isEqualTo(foundCounty)
    }

    @Test
    fun getCountyByIdUseCase_whenCountyIsNotFound_returnsNull() {
        // Given
        val countyId = 1L
        `when`(mockGetCountyByIdUseCase.get(countyId)).thenReturn(null)

        // When
        val foundCounty = subject.getCountyById(countyId)

        // Then
        verify(mockGetCountyByIdUseCase).get(countyId)
        assertThat(foundCounty).isNull()
    }

    @Test
    fun getAllCountiesUseCase_whenCountiesAreFound_returnsCountyList() {
        // Given
        val counties = listOf<County>()
        `when`(mockGetAllCountiesUseCase.get()).thenReturn(counties)

        // When
        val foundCounties = subject.getAllCounties()

        // Then
        verify(mockGetAllCountiesUseCase).get()
        assertThat(counties).isEqualTo(foundCounties)
    }
}
