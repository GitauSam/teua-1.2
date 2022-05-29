package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.api.UserServicePort
import com.zenza.teua.domain.usecases.interfaces.users.CreateUserUseCase
import com.zenza.teua.domain.usecases.interfaces.users.GetAllUsersUseCase
import com.zenza.teua.domain.usecases.interfaces.users.GetUserByIdUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class UserServiceImpl(
    private val createUserUseCase: CreateUserUseCase?,
    private val getAllUsersUseCase: GetAllUsersUseCase?,
    private val getUserByIdUseCase: GetUserByIdUseCase
): UserServicePort {

    override fun addUser(user: User): User? {
        return createUserUseCase!!.create(user)
    }

    override fun getUsers(): List<User?> {
        return getAllUsersUseCase!!.get()
    }

    override fun getUserById(userId: Long): User? {
        return getUserByIdUseCase.getById(userId)
    }
}
