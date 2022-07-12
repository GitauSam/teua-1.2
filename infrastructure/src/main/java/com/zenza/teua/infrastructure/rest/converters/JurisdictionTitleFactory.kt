package com.zenza.teua.infrastructure.rest.converters

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.infrastructure.rest.request.CreateJurisdictionTitleRequest

class JurisdictionTitleFactory {

    companion object {

        fun buildJurisdictionTitle(
            createJurisdictionTitleRequest: CreateJurisdictionTitleRequest
        ): JurisdictionTitle {

            return JurisdictionTitle().apply {
                title = createJurisdictionTitleRequest.title
            }
        }
    }
}
