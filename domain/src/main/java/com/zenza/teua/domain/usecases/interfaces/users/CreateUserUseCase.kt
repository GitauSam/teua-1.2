package com.zenza.teua.domain.usecases.interfaces.users

import com.zenza.teua.domain.data.User

interface CreateUserUseCase {

    fun create(user: User): User?
}
