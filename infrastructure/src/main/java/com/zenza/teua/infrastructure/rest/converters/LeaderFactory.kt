package com.zenza.teua.infrastructure.rest.converters

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.infrastructure.rest.request.CreateLeaderRequest

class LeaderFactory {

    companion object {
        fun buildLeader(createLeaderRequest: CreateLeaderRequest): Leader {

            return Leader().apply {
                firstName = createLeaderRequest.firstName
                middleName = createLeaderRequest.middleName
                lastName = createLeaderRequest.lastName
                dateOfBirth = createLeaderRequest.dateOfBirth
            }
        }
    }
}
