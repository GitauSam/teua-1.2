package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.domain.usecases.interfaces.county.CreateCountyUseCase
import lombok.AllArgsConstructor
import java.time.LocalDateTime

@AllArgsConstructor
class CreateCountyUseCaseImpl(
    private val countyPersistencePort: CountyPersistencePort
): CreateCountyUseCase {

    override fun create(county: County): County {
        return countyPersistencePort.addCounty(
            county.apply {
                status = 1
                createdAt = LocalDateTime.now()
                createdBy = "admin"
                modifiedAt = LocalDateTime.now()
                modifiedBy = "admin"
            }
        )
    }
}
