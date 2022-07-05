package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.infrastructure.mappers.*
import com.zenza.teua.infrastructure.repository.JurisdictionTitleEntityRepository
import org.springframework.stereotype.Service

@Service
class JurisdictionTitleEntityJpaAdapter(
    private val jurisdictionTitleEntityRepository: JurisdictionTitleEntityRepository
): JurisdictionTitlePersistencePort {

    override fun createJurisdictionTitle(jurisdictionTitle: JurisdictionTitle): JurisdictionTitle {

        val jurisdictionTitleEntity = jurisdictionTitleEntityRepository
            .save(jurisdictionTitletoJurisdictionTitleEntityConverter(jurisdictionTitle))

        return jurisdictionTitleEntitytoJurisdictionTitleConverter(jurisdictionTitleEntity)
    }

    override fun getJurisdictionTitleById(jurisdictionTitleId: Int): JurisdictionTitle? {

        val jurisdictionTitleEntity = jurisdictionTitleEntityRepository.findById(jurisdictionTitleId)

        return if (jurisdictionTitleEntity.isPresent) {
                    jurisdictionTitleEntitytoJurisdictionTitleConverter(jurisdictionTitleEntity.get())
                } else {
                    null
                }
    }

    override fun getAllJurisdictionTitles(): List<JurisdictionTitle?> {

        val jurisdictionTitleEntities = jurisdictionTitleEntityRepository.findAll()

        val jurisdictionTitleList = mutableListOf<JurisdictionTitle>()

        jurisdictionTitleEntities
            .stream()
            .map { jt -> jurisdictionTitleList.add(jurisdictionTitleEntitytoJurisdictionTitleConverter(jt)) }

        return jurisdictionTitleList
    }
}
