package com.zenza.teua.infrastructure.rest.converters

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.infrastructure.rest.request.CreateWardRequest

class WardFactory {

    companion object {

        fun buildWard(createWardRequest: CreateWardRequest): Ward {

            return Ward().apply {
                name = createWardRequest.name
                county = createWardRequest.county
            }
        }
    }
}
