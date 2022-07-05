package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.infrastructure.mappers.*
import com.zenza.teua.infrastructure.repository.CountyEntityRepository
import org.springframework.stereotype.Service

@Service
class CountyEntityJpaAdapter(
    private val countyEntityRepository: CountyEntityRepository
): CountyPersistencePort {

    override fun addCounty(county: County): County {

        var countyEntity = countyToCountyEntityConverter(county)

        countyEntity = countyEntityRepository.save(countyEntity)

        val savedCounty = countyEntityToCountyConverter(countyEntity)

        return savedCounty!!
    }

    override fun getCounties(): List<County?> {

        val countyEntities = countyEntityRepository.findAll()

        val countyList = mutableListOf<County>()

        countyEntities.stream().map { ce -> countyEntityToCountyConverter(ce)?.let { countyList.add(it) } }

        return countyList
    }

    override fun getCountyById(countyId: Long): County? {

        val countyEntity = countyEntityRepository.findById(countyId)

        return if (countyEntity.isPresent) {
                    countyEntityToCountyConverter(countyEntity.get())!!
                } else {
                    null
                }
    }
}
