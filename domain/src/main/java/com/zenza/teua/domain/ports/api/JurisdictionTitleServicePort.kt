package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.JurisdictionTitle

interface JurisdictionTitleServicePort {

    fun createJurisdictionTitle(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle

    fun getJurisdictionTitleById(jurisdictionTitleId: Int): JurisdictionTitle?

    fun getAllJurisdictionTitles(): List<JurisdictionTitle?>
}
