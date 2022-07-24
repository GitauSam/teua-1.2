package com.zenza.teua.infrastructure.rest.converters

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.data.County
import com.zenza.teua.infrastructure.rest.request.CreateCountyRequest

class CountyFactory {

    companion object {

        fun buildCounty(createCountyRequest: CreateCountyRequest): County {

            return County().apply {
                name = createCountyRequest.name
                country = Country().apply {
                    id = createCountyRequest.country!!.id
                    name = createCountyRequest.country!!.name
                    status = createCountyRequest.country!!.status
                    createdAt = createCountyRequest.country!!.createdAt
                    createdBy = createCountyRequest.country!!.createdBy
                    modifiedAt = createCountyRequest.country!!.modifiedAt
                    modifiedBy = createCountyRequest.country!!.modifiedBy
                    deletedAt = createCountyRequest.country!!.deletedAt
                    deletedBy = createCountyRequest.country!!.deletedBy
                }
            }
        }
    }
}
