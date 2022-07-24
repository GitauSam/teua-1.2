package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.api.CountyServicePort
import com.zenza.teua.domain.usecases.interfaces.county.CreateCountyUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetAllCountiesUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetCountyByIdUseCase

class CountyServiceImpl(
    private val createCountyUseCase: CreateCountyUseCase,
    private val getCountyByIdUseCase: GetCountyByIdUseCase,
    private val getAllCountiesUseCase: GetAllCountiesUseCase
): CountyServicePort {

    override fun createCounty(county: County): County {
        return createCountyUseCase.create(county)
    }

    override fun getCountyById(countyId: Long): County? {
        return getCountyByIdUseCase.get(countyId)
    }

    override fun getAllCounties(): List<County> {
        return getAllCountiesUseCase.get()
    }
}
