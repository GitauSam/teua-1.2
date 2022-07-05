package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.ports.spi.JurisdictionLeaderPersistencePort
import com.zenza.teua.infrastructure.mappers.*
import com.zenza.teua.infrastructure.repository.JurisdictionLeaderEntityRepository
import org.springframework.stereotype.Service

@Service
class JurisdictionLeaderEntityJpaAdapter(
    private val jurisdictionLeaderEntityRepository: JurisdictionLeaderEntityRepository
): JurisdictionLeaderPersistencePort {

    override fun createJurisdictionLeader(jurisdictionLeader: JurisdictionLeader): JurisdictionLeader {

        val jurisdictionLeaderEntity = jurisdictionLeaderEntityRepository
            .save(jurisdictionLeaderToJurisdictionLeaderEntityConverter(jurisdictionLeader))

        return jurisdictionLeaderEntityToJurisdictionLeaderConverter(jurisdictionLeaderEntity)
    }

    override fun getJurisdictionLeaderById(jurisdictionLeaderId: Long): JurisdictionLeader? {

        val jurisdictionLeaderEntity = jurisdictionLeaderEntityRepository.findById(jurisdictionLeaderId)

        return if (jurisdictionLeaderEntity.isPresent) {
                    jurisdictionLeaderEntityToJurisdictionLeaderConverter(jurisdictionLeaderEntity.get())
                } else {
                    null
                }
    }

    override fun getAllJurisdictionLeaders(): List<JurisdictionLeader> {

        val jurisdictionLeaderEntities = jurisdictionLeaderEntityRepository.findAll()

        val jurisdictionLeadersList = mutableListOf<JurisdictionLeader>()

        jurisdictionLeaderEntities
            .stream()
            .map { jl -> jurisdictionLeadersList.add(jurisdictionLeaderEntityToJurisdictionLeaderConverter(jl)) }

        return jurisdictionLeadersList
    }
}
