package com.zenza.teua.domain.usecases.interfaces.ward

import com.zenza.teua.domain.data.Ward

interface CreateWardUseCase {

    fun create(ward: Ward): Ward
}
