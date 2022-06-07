package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.County

interface CountyServicePort {

    fun createCounty(county: County): County

    fun getCountyById(countyId: Long): County?

    fun getAllCounties(): List<County?>
}
