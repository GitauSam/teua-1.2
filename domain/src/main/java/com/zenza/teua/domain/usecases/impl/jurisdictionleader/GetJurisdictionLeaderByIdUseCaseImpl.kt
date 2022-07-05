package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictionleader.GetJurisdictionLeaderByIdUseCase

class GetJurisdictionLeaderByIdUseCaseImpl(
    private val jurisdictionLeaderPersistencePort: JurisdictionLeaderPersistencePort
): GetJurisdictionLeaderByIdUseCase {

    override fun get(jurisdictionLeaderId: Long): JurisdictionLeader? {

        return jurisdictionLeaderPersistencePort.getJurisdictionLeaderById(jurisdictionLeaderId)
    }
}
