package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class GetAllUsersUseCaseImplTest {

    @Test
    fun getAllUsers_whenUsersFound_returnUsersList() {
        val usersList = listOf<User>()

        val mockUserPersistencePort = mock(UserPersistencePort::class.java)
        val getAllUsersUseCaseImpl = GetAllUsersUseCaseImpl(mockUserPersistencePort)
        `when`(mockUserPersistencePort.getUsers()).thenReturn(usersList)

        val fetchedUsersList = getAllUsersUseCaseImpl.get()

        verify(mockUserPersistencePort).getUsers()

        assertThat(usersList == fetchedUsersList).isTrue
    }
}