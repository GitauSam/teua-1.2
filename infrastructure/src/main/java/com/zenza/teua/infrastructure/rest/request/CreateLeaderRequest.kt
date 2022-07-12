package com.zenza.teua.infrastructure.rest.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateLeaderRequest(

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "First name is mandatory")
    var firstName: String? = null,

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "Middle name is mandatory")
    var middleName: String? = null,

    @Size(message = "Character count should 1 - 255", max = 255)
    @NotBlank(message = "Last name is mandatory")
    var lastName: String? = null,

    @NotBlank(message = "Date of birth is mandatory")
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    var dateOfBirth: LocalDateTime? = null,
)