package com.zenza.teua.domain.ports.spi

import com.zenza.teua.domain.data.Ward

interface WardPersistencePort {

    fun addWard(ward: Ward): Ward

    fun getWards(): List<Ward?>

    fun getWardById(wardId: Long): Ward?
}
