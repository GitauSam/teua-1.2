package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.Leader

interface LeaderPersistencePort {

    fun createLeader(leader: Leader): Leader

    fun getLeaders(): List<Leader>

    fun getLeaderById(leaderId: Long): Leader?
}
