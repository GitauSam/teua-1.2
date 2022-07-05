package com.zenza.teua.domain.usecases.interfaces.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader

interface GetJurisdictionLeaderByIdUseCase {

    fun get(jurisdictionLeaderId: Long): JurisdictionLeader?
}
