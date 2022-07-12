package com.zenza.teua.infrastructure.persistence.adapters

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.infrastructure.persistence.mappers.leaderEntitytoLeaderConverter
import com.zenza.teua.infrastructure.persistence.mappers.leadertoLeaderEntityConverter
import com.zenza.teua.infrastructure.persistence.repository.LeaderEntityRepository
import org.springframework.stereotype.Service

@Service
class LeaderEntityJpaAdapter(
    private val leaderEntityRepository: LeaderEntityRepository
): LeaderPersistencePort {

    override fun createLeader(leader: Leader): Leader {

        val leaderEntity = leaderEntityRepository.save(leadertoLeaderEntityConverter(leader))

        return leaderEntitytoLeaderConverter(leaderEntity)
    }

    override fun getLeaders(): List<Leader> {

        val leaderEntities = leaderEntityRepository.findAll()

        val leaderList = mutableListOf<Leader>()

        leaderEntities
            .forEach { l -> leaderList.add(leaderEntitytoLeaderConverter(l)) }

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
