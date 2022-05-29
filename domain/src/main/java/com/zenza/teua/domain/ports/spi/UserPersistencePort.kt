package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.User

interface UserPersistencePort {

    fun addUser(user: User): User?

    fun getUsers(): List<User>

    fun getUserById(userId: Long): User?
}
