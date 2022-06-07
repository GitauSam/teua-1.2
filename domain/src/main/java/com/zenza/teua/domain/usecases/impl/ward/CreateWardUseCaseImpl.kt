package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import com.zenza.teua.domain.usecases.interfaces.ward.CreateWardUseCase

class CreateWardUseCaseImpl(
    private val wardPersistencePort: WardPersistencePort
): CreateWardUseCase {

    override fun create(ward: Ward): Ward {
        return wardPersistencePort.addWard(ward)
    }
}
