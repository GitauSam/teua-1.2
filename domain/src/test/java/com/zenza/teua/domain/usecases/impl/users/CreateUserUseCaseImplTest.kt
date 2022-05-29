package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import io.github.serpro69.kfaker.faker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class CreateUserUseCaseImplTest {

    private val faker = faker {  }

    @Test
    fun create_whenUserIsCreatedSuccessfully_returnSavedUser() {
        val userToBeSaved = User(
            firstName = faker.name.firstName(),
            lastName = faker.name.lastName(),
            email = faker.internet.email(),
            username = faker.name.name(),
            phoneNumber = faker.phoneNumber.phoneNumber(),
            password = faker.random.randomString(length = 12, numericalChars = true),
            status = 1
        )

        val mockUserPersistencePort = mock(UserPersistencePort::class.java)
        val createUserUseCaseImpl = CreateUserUseCaseImpl(mockUserPersistencePort)
        `when`(mockUserPersistencePort.addUser(userToBeSaved)).thenReturn(userToBeSaved)

        val savedUser = createUserUseCaseImpl.create(userToBeSaved)

        assertThat(userToBeSaved == savedUser).isTrue

        verify(mockUserPersistencePort).addUser(userToBeSaved)
    }
}