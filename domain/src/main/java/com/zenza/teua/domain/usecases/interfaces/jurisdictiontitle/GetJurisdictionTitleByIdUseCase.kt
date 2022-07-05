package com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle

interface GetJurisdictionTitleByIdUseCase {

    fun get(jurisdictionTitleId: Int): JurisdictionTitle?
}
