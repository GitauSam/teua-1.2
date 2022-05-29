package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetUserByIdUseCaseImplTest {

    private val faker = faker {  }
    private val mockUserPersistencePort: UserPersistencePort = mock(UserPersistencePort::class.java)
    private val subject = GetUserByIdUseCaseImpl(mockUserPersistencePort)

    @Test
    fun getUserById_whenUserIsFound_returnsUser() {
        val testUser = User(
            id = 1,
            firstName = faker.name.firstName(),
            lastName = faker.name.lastName(),
            email = faker.internet.email(),
            phoneNumber = faker.phoneNumber.phoneNumber(),
            username = faker.name.name(),
            status = 1,
            password = faker.random.randomString(12, numericalChars = true)
        )

        `when`(mockUserPersistencePort.getUserById(1)).thenReturn(testUser)

        val fetchedUser = subject.getById(1)

        verify(mockUserPersistencePort).getUserById(1)

        assertThat(fetchedUser).isNotNull
        assertThat(testUser == fetchedUser).isTrue
    }
}