package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import com.zenza.teua.infrastructure.mappers.*
import com.zenza.teua.infrastructure.repository.WardEntityRepository
import org.springframework.stereotype.Service

@Service
class WardEntityJpaAdapter(
    private val wardEntityRepository: WardEntityRepository
): WardPersistencePort {

    override fun addWard(ward: Ward): Ward {

        val wardEntity = wardEntityRepository.save(wardToWardEntityConverter(ward))

        return wardEntityToWardConverter(wardEntity)!!
    }

    override fun getWards(): List<Ward?> {

        val wardEntities = wardEntityRepository.findAll()

        val wardList = mutableListOf<Ward>()

        wardEntities
            .stream()
            .map { w -> wardList.add(wardEntityToWardConverter(w)!!) }

        return wardList
    }

    override fun getWardById(wardId: Long): Ward? {

        val wardEntity = wardEntityRepository.findById(wardId)

        return if (wardEntity.isPresent) {
                    wardEntityToWardConverter(wardEntity.get())
                } else {
                    null
                }
    }
}
