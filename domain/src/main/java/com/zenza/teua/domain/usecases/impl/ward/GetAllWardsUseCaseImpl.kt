package com.zenza.teua.domain.usecases.impl.ward

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import com.zenza.teua.domain.usecases.interfaces.ward.GetAllWardsUseCase

class GetAllWardsUseCaseImpl(
    private val wardPersistencePort: WardPersistencePort
): GetAllWardsUseCase {

    override fun get(): List<Ward?> {
        return wardPersistencePort.getWards()
    }
}
