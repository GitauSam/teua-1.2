package com.zenza.teua.domain.usecases.impl.users

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import com.zenza.teua.domain.usecases.interfaces.users.CreateUserUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class CreateUserUseCaseImpl(
    private val userPersistencePort: UserPersistencePort?
): CreateUserUseCase {

    override fun create(user: User): User? {
        return userPersistencePort!!.addUser(user)!!
    }
}
