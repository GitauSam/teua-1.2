package com.zenza.teua.domain.usecases.interfaces.county

import com.zenza.teua.domain.data.County

interface GetCountyByIdUseCase {

    fun get(countyId: Long): County?
}
