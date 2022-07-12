package com.zenza.teua.infrastructure.rest.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateJurisdictionTitleRequest(

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "Middle name is mandatory")
    var title: String? = null,
)