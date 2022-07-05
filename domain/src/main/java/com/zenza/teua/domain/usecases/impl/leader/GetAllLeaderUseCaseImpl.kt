package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.leader.GetAllLeadersUseCase

class GetAllLeaderUseCaseImpl(
    private val leaderPersistencePort: LeaderPersistencePort
): GetAllLeadersUseCase {

    override fun get(): List<Leader?> {
        return leaderPersistencePort.getLeaders()
    }
}
