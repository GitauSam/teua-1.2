package com.zenza.teua.infrastructure.rest.controllers

import com.google.common.base.Preconditions
import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.api.WardServicePort
import com.zenza.teua.infrastructure.rest.converters.WardFactory
import com.zenza.teua.infrastructure.rest.request.CreateWardRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/ward")
@RestController
class WardController(
    private val wardServicePort: WardServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createWard(@Valid @RequestBody createWardRequest: CreateWardRequest): Ward {

        Preconditions.checkNotNull(createWardRequest)

        val ward = WardFactory.buildWard(createWardRequest)

        return wardServicePort.createWard(ward)
    }

    @GetMapping("/{ward-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getWardById(@PathVariable("ward-id") wardId: Long): Ward? {

        return wardServicePort.getWardById(wardId)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllWards(): List<Ward> {

        return wardServicePort.getAllWards()
    }
}
