package com.zenza.teua.infrastructure.rest.controllers

import com.google.common.base.Preconditions
import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.api.CountryServicePort
import com.zenza.teua.infrastructure.rest.converters.CountryFactory
import com.zenza.teua.infrastructure.rest.request.CreateCountryRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("country")
class CountryController(
    private val countryServicePort: CountryServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCountry(@Valid @RequestBody createCountryRequest: CreateCountryRequest): Country {

        Preconditions.checkNotNull(createCountryRequest)

        val country = CountryFactory.buildCountry(createCountryRequest)

        return countryServicePort.createCountry(country)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllCountries(): List<Country> {

        return countryServicePort.getCountries()
    }

    @GetMapping("/{country-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCountryById(@PathVariable("country-id") countryId: Long): Country? {

        return countryServicePort.getCountryById(countryId)
    }
}
