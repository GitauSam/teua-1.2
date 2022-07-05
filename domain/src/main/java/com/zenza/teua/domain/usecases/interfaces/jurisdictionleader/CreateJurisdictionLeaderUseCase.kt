package com.zenza.teua.domain.usecases.interfaces.jurisdictionleader

import com.zenza.teua.domain.data.JurisdictionLeader

interface CreateJurisdictionLeaderUseCase {

    fun create(jurisdictionLeader: JurisdictionLeader): JurisdictionLeader
}
