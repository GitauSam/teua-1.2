package com.zenza.teua.domain.usecases.interfaces.country

import com.zenza.teua.domain.data.Country

interface GetCountryByIdUseCase {

    fun get(countryId: Long): Country?
}