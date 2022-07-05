package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.Leader

interface LeaderServicePort {

    fun createLeader(leader: Leader): Leader

    fun getLeaders(): List<Leader?>

    fun getLeaderById(leaderId: Long): Leader?
}
