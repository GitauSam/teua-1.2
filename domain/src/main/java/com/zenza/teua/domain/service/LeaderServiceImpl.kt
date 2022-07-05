package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.api.LeaderServicePort
import com.zenza.teua.domain.usecases.interfaces.leader.CreateLeaderUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetAllLeadersUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetLeaderByIdUseCase

class LeaderServiceImpl(
    private val createLeaderUseCase: CreateLeaderUseCase,
    private val getLeaderByIdUseCase: GetLeaderByIdUseCase,
    private val getAllLeadersUseCase: GetAllLeadersUseCase
): LeaderServicePort {

    override fun createLeader(leader: Leader): Leader {
        return createLeaderUseCase.create(leader)
    }

    override fun getLeaders(): List<Leader?> {
        return getAllLeadersUseCase.get()
    }

    override fun getLeaderById(leaderId: Long): Leader? {
        return getLeaderByIdUseCase.get(leaderId)
    }
}
