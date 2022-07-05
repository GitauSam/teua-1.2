package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetAllJurisdictionTitlesUseCase

class GetAllJurisdictionTitlesUseCaseImpl(
    private val jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort
): GetAllJurisdictionTitlesUseCase {

    override fun get(): List<JurisdictionTitle?> {
        return jurisdictionTitlePersistencePort.getAllJurisdictionTitles()
    }
}
