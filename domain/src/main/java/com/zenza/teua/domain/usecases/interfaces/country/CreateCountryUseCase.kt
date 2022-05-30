package com.zenza.teua.domain.usecases.interfaces.country

import com.zenza.teua.domain.data.Country

interface CreateCountryUseCase {

    fun create(country: Country): Country
}
