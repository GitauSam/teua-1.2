package com.zenza.teua.infrastructure.rest.request

import com.zenza.teua.domain.data.Country
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateCountyRequest(

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "County name is mandatory")
    var name: String? = null,

    @NotBlank(message = "Country is mandatory")
    var country: Country? = null
)