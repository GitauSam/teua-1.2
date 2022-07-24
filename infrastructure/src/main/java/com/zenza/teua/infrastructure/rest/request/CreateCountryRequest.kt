package com.zenza.teua.infrastructure.rest.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateCountryRequest(

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "Country name is mandatory")
    var name: String? = null,
)
