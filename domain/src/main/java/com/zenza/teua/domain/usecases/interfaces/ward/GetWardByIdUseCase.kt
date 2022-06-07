package com.zenza.teua.domain.usecases.interfaces.ward

import com.zenza.teua.domain.data.Ward

interface GetWardByIdUseCase {

    fun get(wardId: Long): Ward?
}
