package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.infrastructure.mappers.*
import com.zenza.teua.infrastructure.repository.LeaderEntityRepository
import org.springframework.stereotype.Service

@Service
class LeaderEntityJpaAdapter(
    private val leaderEntityRepository: LeaderEntityRepository
): LeaderPersistencePort {

    override fun createLeader(leader: Leader): Leader {

        val leaderEntity = leaderEntityRepository.save(leadertoLeaderEntityConverter(leader))

        return leaderEntitytoLeaderConverter(leaderEntity)
    }

    override fun getLeaders(): List<Leader?> {

        val leaderEntities = leaderEntityRepository.findAll()

        val leaderList = mutableListOf<Leader>()

        leaderEntities
            .stream()
            .map { l -> leaderList.add(leaderEntitytoLeaderConverter(l)) }

        return leaderList
    }

    override fun getLeaderById(leaderId: Long): Leader? {

        val leaderEntity = leaderEntityRepository.findById(leaderId)

        return if (leaderEntity.isPresent) {
                    leaderEntitytoLeaderConverter(leaderEntity.get())
                } else {
                    null
                }
    }
}
