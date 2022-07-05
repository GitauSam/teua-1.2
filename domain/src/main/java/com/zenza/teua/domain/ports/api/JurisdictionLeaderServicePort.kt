package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.JurisdictionLeader

interface JurisdictionLeaderServicePort {

    fun createJurisdictionLeader(jurisdictionLeader: JurisdictionLeader): JurisdictionLeader

    fun getJurisdictionLeaderById(jurisdictionLeaderId: Long): JurisdictionLeader?

    fun getAllJurisdictionLeaders(): List<JurisdictionLeader>
}
