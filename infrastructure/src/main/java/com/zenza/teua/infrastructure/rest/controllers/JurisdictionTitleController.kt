package com.zenza.teua.infrastructure.rest.controllers

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.api.JurisdictionTitleServicePort
import com.zenza.teua.infrastructure.rest.converters.JurisdictionTitleFactory
import com.zenza.teua.infrastructure.rest.request.CreateJurisdictionTitleRequest
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
@RequestMapping("/jurisdiction-title")
class JurisdictionTitleController(
    private val jurisdictionTitleServicePort: JurisdictionTitleServicePort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createJurisdictionTitle(
        @Valid @RequestBody createJurisdictionTitleRequest: CreateJurisdictionTitleRequest
    ): JurisdictionTitle {

        val jurisdictionTitle = JurisdictionTitleFactory.buildJurisdictionTitle(createJurisdictionTitleRequest)

        return jurisdictionTitleServicePort.createJurisdictionTitle(jurisdictionTitle)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllJurisdictionTitles(): List<JurisdictionTitle> {

        return jurisdictionTitleServicePort.getAllJurisdictionTitles()
    }

    @GetMapping("/{jurisdiction-title-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getJurisdictionTitleById(@PathVariable("jurisdiction-title-id") jurisdictionTitleId: Int): JurisdictionTitle? {

        return jurisdictionTitleServicePort.getJurisdictionTitleById(jurisdictionTitleId)
    }
}
