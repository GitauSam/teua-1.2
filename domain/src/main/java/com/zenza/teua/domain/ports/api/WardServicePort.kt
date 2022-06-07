package com.zenza.teua.domain.ports.api

import com.zenza.teua.domain.data.Ward

interface WardServicePort {

    fun createWard(ward: Ward): Ward

    fun getWardById(wardId: Long): Ward?

    fun getAllWards(): List<Ward?>
}
