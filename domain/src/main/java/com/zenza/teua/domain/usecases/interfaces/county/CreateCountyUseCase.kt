package com.zenza.teua.domain.usecases.interfaces.county

import com.zenza.teua.domain.data.County

interface CreateCountyUseCase {

    fun create(county: County): County
}
