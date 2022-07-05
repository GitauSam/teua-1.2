package com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle

interface CreateJurisdictionTitleUseCase {

    fun create(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle
}
