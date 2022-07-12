package com.zenza.teua.domain.usecases.impl.leader

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.domain.usecases.interfaces.leader.CreateLeaderUseCase
import java.time.LocalDateTime

class CreateLeaderUseCaseImpl(
    private val leaderPersistencePort: LeaderPersistencePort
): CreateLeaderUseCase {

    override fun create(leader: Leader): Leader {
        return leaderPersistencePort.createLeader(
            leader.apply {
                status = 1
                createdAt = LocalDateTime.now()
                createdBy = "admin"
                modifiedAt = LocalDateTime.now()
                modifiedBy = "admin"
            }
        )
    }
}
