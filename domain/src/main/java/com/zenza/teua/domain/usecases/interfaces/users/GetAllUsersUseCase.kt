package com.zenza.teua.domain.usecases.interfaces.users

import com.zenza.teua.domain.data.User

interface GetAllUsersUseCase {

    fun get(): List<User?>
}