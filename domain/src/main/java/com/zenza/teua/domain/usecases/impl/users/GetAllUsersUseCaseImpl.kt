package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import com.zenza.teua.domain.usecases.interfaces.users.GetAllUsersUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetAllUsersUseCaseImpl(
    private val userPersistencePort: UserPersistencePort?
): GetAllUsersUseCase {

    override fun get(): List<User?> {
        return userPersistencePort!!.getUsers()
    }
}
