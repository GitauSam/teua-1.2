package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.CreateJurisdictionTitleUseCase

class CreateJurisdictionTitleUseCaseImpl(
    private val jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort
): CreateJurisdictionTitleUseCase {

    override fun create(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle {

        return jurisdictionTitlePersistencePort.createJurisdictionTitle(jurisdictionTitle)
    }
}
