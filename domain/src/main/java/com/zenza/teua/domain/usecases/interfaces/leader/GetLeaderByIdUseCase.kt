package com.zenza.teua.domain.usecases.interfaces.leader

import com.zenza.teua.domain.data.Leader

interface GetLeaderByIdUseCase {

    fun get(leaderId: Long): Leader?
}
