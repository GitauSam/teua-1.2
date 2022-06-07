package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.domain.usecases.interfaces.county.GetCountyByIdUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetCountyByIdUseCaseImpl(
    private val countyPersistencePort: CountyPersistencePort
): GetCountyByIdUseCase {

    override fun get(countyId: Long): County? {
        return countyPersistencePort.getCountyById(countyId)
    }
}
