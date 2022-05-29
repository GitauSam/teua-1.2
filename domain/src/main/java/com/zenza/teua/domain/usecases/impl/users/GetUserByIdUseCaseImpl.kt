package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import com.zenza.teua.domain.usecases.interfaces.users.GetUserByIdUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetUserByIdUseCaseImpl(
    private val userPersistencePort: UserPersistencePort?
): GetUserByIdUseCase {

    override fun getById(userId: Long): User? {
        return userPersistencePort!!.getUserById(userId)
    }
}
