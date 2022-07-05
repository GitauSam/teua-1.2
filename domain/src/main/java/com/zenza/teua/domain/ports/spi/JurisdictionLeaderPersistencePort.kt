package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.JurisdictionLeader

interface JurisdictionLeaderPersistencePort {

    fun createJurisdictionLeader(jurisdictionLeader: JurisdictionLeader): JurisdictionLeader

    fun getJurisdictionLeaderById(jurisdictionLeaderId: Long): JurisdictionLeader?

    fun getAllJurisdictionLeaders(): List<JurisdictionLeader>
}
