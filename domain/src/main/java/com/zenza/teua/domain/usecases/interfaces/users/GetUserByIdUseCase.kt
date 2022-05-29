package com.zenza.teua.domain.usecases.interfaces.users

import com.zenza.teua.domain.data.User

interface GetUserByIdUseCase {

    fun getById(userId: Long): User?
}