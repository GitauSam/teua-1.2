package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictionleader.GetAllJurisdictionLeadersUseCase

class GetAllJurisdictionLeadersUseCaseImpl(
    private val jurisdictionLeaderPersistencePort: JurisdictionLeaderPersistencePort
): GetAllJurisdictionLeadersUseCase {

    override fun get(): List<JurisdictionLeader> {

        return jurisdictionLeaderPersistencePort.getAllJurisdictionLeaders()
    }
}
