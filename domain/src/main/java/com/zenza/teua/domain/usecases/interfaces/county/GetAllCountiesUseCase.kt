package com.zenza.teua.domain.usecases.interfaces.county

import com.zenza.teua.domain.data.County

interface GetAllCountiesUseCase {

    fun get(): List<County>
}
