package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.api.JurisdictionTitleServicePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.CreateJurisdictionTitleUseCase
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetAllJurisdictionTitlesUseCase
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetJurisdictionTitleByIdUseCase

class JurisdictionTitleServiceImpl(
    private val createJurisdictionTitleUseCase: CreateJurisdictionTitleUseCase,
    private val getJurisdictionTitleByIdUseCase: GetJurisdictionTitleByIdUseCase,
    private val getAllJurisdictionTitlesUseCase: GetAllJurisdictionTitlesUseCase
): JurisdictionTitleServicePort {

    override fun createJurisdictionTitle(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle {
        return createJurisdictionTitleUseCase.create(jurisdictionTitle)
    }

    override fun getJurisdictionTitleById(jurisdictionTitleId: Int): JurisdictionTitle? {
        return getJurisdictionTitleByIdUseCase.get(jurisdictionTitleId)
    }

    override fun getAllJurisdictionTitles(): List<JurisdictionTitle> {
        return getAllJurisdictionTitlesUseCase.get()
    }
}
