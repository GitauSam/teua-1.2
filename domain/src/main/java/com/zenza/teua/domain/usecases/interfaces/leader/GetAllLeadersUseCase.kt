package com.zenza.teua.domain.usecases.interfaces.leader

import com.zenza.teua.domain.data.Leader

interface GetAllLeadersUseCase {

    fun get(): List<Leader?>
}
