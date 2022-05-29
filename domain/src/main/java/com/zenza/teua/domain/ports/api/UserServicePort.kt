package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.User

interface UserServicePort {

    fun addUser(user: User): User?

    fun getUsers(): List<User?>

    fun getUserById(userId: Long): User?
}
