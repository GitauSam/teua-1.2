package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.JurisdictionTitle

interface JurisdictionTitlePersistencePort {

    fun createJurisdictionTitle(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle

    fun getJurisdictionTitleById(jurisdictionTitleId: Int): JurisdictionTitle?

    fun getAllJurisdictionTitles(): List<JurisdictionTitle?>
}
