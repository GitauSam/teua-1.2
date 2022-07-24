package com.zenza.teua.infrastructure.rest.request

import com.zenza.teua.domain.data.County
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateWardRequest(

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "Country name is mandatory")
    var name: String? = null,

    @NotBlank(message = "County is mandatory")
    var county: County? = null,
)
