package com.zenza.teua.domain.usecases.impl.jurisdictiontitle

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.CreateJurisdictionTitleUseCase
import java.time.LocalDateTime

class CreateJurisdictionTitleUseCaseImpl(
    private val jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort
): CreateJurisdictionTitleUseCase {

    override fun create(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle {

        return jurisdictionTitlePersistencePort.createJurisdictionTitle(
            jurisdictionTitle.apply {
                status = 1
                createdAt = LocalDateTime.now()
                createdBy = "admin"
                modifiedAt = LocalDateTime.now()
                modifiedBy = "admin"
            }
        )
    }
}
