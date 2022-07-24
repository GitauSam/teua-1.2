package com.zenza.teua.infrastructure.rest.controllers

import com.google.common.base.Preconditions
import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.api.CountyServicePort
import com.zenza.teua.infrastructure.rest.converters.CountyFactory
import com.zenza.teua.infrastructure.rest.request.CreateCountyRequest
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
@RequestMapping("/county")
class CountyController(
     private val countyServicePort: CountyServicePort
) {

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     fun createCounty(@Valid @RequestBody createCountyRequest: CreateCountyRequest): County {

          Preconditions.checkNotNull(createCountyRequest)

          val county = CountyFactory.buildCounty(createCountyRequest)

          return countyServicePort.createCounty(county)
     }

     @GetMapping("/{county-id}")
     @ResponseStatus(HttpStatus.OK)
     fun getCountyById(@PathVariable("county-id") countyId: Long): County? {

          return countyServicePort.getCountyById(countyId)
     }

     @GetMapping
     @ResponseStatus(HttpStatus.OK)
     fun getAllCounties(): List<County> {

          return countyServicePort.getAllCounties()
     }
}
