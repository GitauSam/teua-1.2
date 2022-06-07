package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.domain.usecases.interfaces.county.CreateCountyUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class CreateCountyUseCaseImpl(
    private val countyPersistencePort: CountyPersistencePort
): CreateCountyUseCase {

    override fun create(county: County): County {
        return countyPersistencePort.addCounty(county)
    }
}
