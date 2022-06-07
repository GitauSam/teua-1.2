package com.zenza.teua.domain.service

import com.zenza.teua.domain.data.Ward
import com.zenza.teua.domain.ports.api.WardServicePort
import com.zenza.teua.domain.usecases.interfaces.ward.CreateWardUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetAllWardsUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetWardByIdUseCase

class WardServiceImpl(
    private val createWardUseCase: CreateWardUseCase,
    private val getWardByIdUseCase: GetWardByIdUseCase,
    private val getAllWardsUseCase: GetAllWardsUseCase
): WardServicePort {

    override fun createWard(ward: Ward): Ward {
        return createWardUseCase.create(ward)
    }

    override fun getWardById(wardId: Long): Ward? {
        return getWardByIdUseCase.get(wardId)
    }

    override fun getAllWards(): List<Ward?> {
        return getAllWardsUseCase.get()
    }
}
