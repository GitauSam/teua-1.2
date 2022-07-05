package com.zenza.teua.domain.usecases.impl.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.jurisdictionleader.CreateJurisdictionLeaderUseCase

class CreateJurisdictionLeaderUseCaseImpl(
    private val jurisdictionLeaderPersistencePort: JurisdictionLeaderPersistencePort
): CreateJurisdictionLeaderUseCase {

    override fun create(jurisdictionLeader: JurisdictionLeader): JurisdictionLeader {

        return jurisdictionLeaderPersistencePort.createJurisdictionLeader(jurisdictionLeader)
    }
}
