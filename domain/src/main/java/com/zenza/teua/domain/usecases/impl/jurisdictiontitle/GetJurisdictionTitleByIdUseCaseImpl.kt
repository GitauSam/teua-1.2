package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetJurisdictionTitleByIdUseCase

class GetJurisdictionTitleByIdUseCaseImpl(
    private val jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort
): GetJurisdictionTitleByIdUseCase {

    override fun get(jurisdictionTitleId: Int): JurisdictionTitle? {
        return jurisdictionTitlePersistencePort.getJurisdictionTitleById(jurisdictionTitleId)
    }
}
