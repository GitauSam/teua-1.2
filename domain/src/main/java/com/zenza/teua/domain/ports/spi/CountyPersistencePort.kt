package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.County

interface CountyPersistencePort {

    fun addCounty(county: County): County

    fun getCounties(): List<County>

    fun getCountyById(countyId: Long): County?
}
