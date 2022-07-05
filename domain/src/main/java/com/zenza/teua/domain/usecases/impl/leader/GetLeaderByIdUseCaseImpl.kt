package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.leader.GetLeaderByIdUseCase

class GetLeaderByIdUseCaseImpl(
    private val leaderPersistencePort: LeaderPersistencePort
): GetLeaderByIdUseCase {

    override fun get(leaderId: Long): Leader? {
        return leaderPersistencePort.getLeaderById(leaderId)
    }
}
