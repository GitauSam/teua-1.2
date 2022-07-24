package com.zenza.teua.infrastructure.rest.converters

import com.zenza.teua.domain.data.Country
import com.zenza.teua.infrastructure.rest.request.CreateCountryRequest

class CountryFactory {

    companion object {

        fun buildCountry(createCountryRequest: CreateCountryRequest): Country {

            return Country().apply {
                name = createCountryRequest.name
            }
        }
    }
}
