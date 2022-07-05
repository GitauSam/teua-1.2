package com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle

interface GetAllJurisdictionTitlesUseCase {

    fun get(): List<JurisdictionTitle?>
}
