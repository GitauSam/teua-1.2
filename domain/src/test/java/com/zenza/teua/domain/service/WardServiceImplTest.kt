package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.usecases.interfaces.ward.CreateWardUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetAllWardsUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetWardByIdUseCase
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class WardServiceImplTest {

    private val faker = faker {  }
    private val mockCreateWardUseCase = mock(CreateWardUseCase::class.java)
    private val mockGetAllWardsUseCase = mock(GetAllWardsUseCase::class.java)
    private val mockGetWardByIdUseCase = mock(GetWardByIdUseCase::class.java)
    private val subject = WardServiceImpl(
        mockCreateWardUseCase,
        mockGetWardByIdUseCase,
        mockGetAllWardsUseCase
    )

    @Test
    fun createWardUseCase_whenWardIsCreated_returnsWard() {
        // Given
        val ward = Ward(
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockCreateWardUseCase.create(ward)).thenReturn(ward)

        // When
        val createdWard = subject.createWard(ward)

        // Then
        verify(mockCreateWardUseCase).create(ward)
        assertThat(createdWard).isNotNull
        assertThat(ward).isEqualTo(createdWard)
    }

    @Test
    fun getWardByIdUseCase_whenWardIsFound_returnsWard() {
        // Given
        val wardId = 1L
        val ward = Ward(
            id = 1L,
            name = faker.random.randomString(12),
            status = 1
        )
        `when`(mockGetWardByIdUseCase.get(wardId)).thenReturn(ward)

        // When
        val foundWard = subject.getWardById(wardId)

        // Then
        verify(mockGetWardByIdUseCase).get(wardId)
        assertThat(foundWard).isNotNull
        assertThat(foundWard).isEqualTo(ward)
    }

    @Test
    fun getWardByIdUseCase_whenWardIsNotFound_returnsNull() {
        // Given
        val wardId = 1L
        `when`(mockGetWardByIdUseCase.get(wardId)).thenReturn(null)

        // When
        val foundWard = subject.getWardById(wardId)

        // Then
        verify(mockGetWardByIdUseCase).get(wardId)
        assertThat(foundWard).isNull()
    }

    @Test
    fun getAllWardsUseCase_whenWardsAreFound_returnWardsList() {
        // Given
        val wards = listOf<Ward>()
        `when`(mockGetAllWardsUseCase.get()).thenReturn(wards)

        // When
        val foundWards = subject.getAllWards()

        // Then
        verify(mockGetAllWardsUseCase).get()
        assertThat(wards).isEqualTo(foundWards)
    }
}
