package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import com.zenza.teua.domain.usecases.interfaces.ward.GetWardByIdUseCase
import lombok.AllArgsConstructor

@AllArgsConstructor
class GetWardByIdUseCaseImpl(
    private val wardPersistencePort: WardPersistencePort
): GetWardByIdUseCase {

    override fun get(wardId: Long): Ward? {
        return wardPersistencePort.getWardById(wardId)
    }
}
