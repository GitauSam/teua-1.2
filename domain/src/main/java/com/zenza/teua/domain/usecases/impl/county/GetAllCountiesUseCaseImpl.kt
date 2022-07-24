package com.zenza.teua.domain.usecases.impl.county

import com.zenza.teua.domain.data.County
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.domain.usecases.interfaces.county.GetAllCountiesUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetAllCountiesUseCaseImpl(
    private val  countyPersistencePort: CountyPersistencePort
): GetAllCountiesUseCase {

    override fun get(): List<County> {
        return countyPersistencePort.getCounties()
    }
}
