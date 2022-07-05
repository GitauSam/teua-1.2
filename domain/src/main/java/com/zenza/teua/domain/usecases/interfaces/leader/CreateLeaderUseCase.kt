package com.zenza.teua.domain.usecases.interfaces.leader

import com.zenza.teua.domain.data.Leader

interface CreateLeaderUseCase {

    fun create(leader: Leader): Leader
}
