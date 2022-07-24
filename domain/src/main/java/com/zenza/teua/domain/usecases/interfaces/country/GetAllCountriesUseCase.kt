package com.zenza.teua.domain.usecases.interfaces.country

import com.zenza.teua.domain.data.Country

interface GetAllCountriesUseCase {

    fun get(): List<Country>
}