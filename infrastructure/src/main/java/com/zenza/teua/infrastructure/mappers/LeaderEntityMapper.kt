package com.zenza.teua.infrastructure.mappers

import com.zenza.teua.domain.data.Leader
import com.zenza.teua.infrastructure.entities.LeaderEntity

fun leaderEntitytoLeaderConverter(leaderEntity: LeaderEntity) = Leader().apply {
    id = leaderEntity.id
    firstName = leaderEntity.firstName
    middleName = leaderEntity.middleName
    lastName = leaderEntity.lastName
    dateOfBirth = leaderEntity.dateOfBirth
    status = leaderEntity.status
    createdAt = leaderEntity.createdAt
    createdBy = leaderEntity.createdBy
    modifiedAt = leaderEntity.modifiedAt
    modifiedBy = leaderEntity.modifiedBy
    deletedAt = leaderEntity.deletedAt
    deletedBy = leaderEntity.deletedBy
}

fun leadertoLeaderEntityConverter(leader: Leader) = LeaderEntity().apply {
    id = leader.id
    firstName = leader.firstName
    middleName = leader.middleName
    lastName = leader.lastName
    dateOfBirth = leader.dateOfBirth
    status = leader.status
    createdAt = leader.createdAt
    createdBy = leader.createdBy
    modifiedAt = leader.modifiedAt
    modifiedBy = leader.modifiedBy!!
    deletedAt = leader.deletedAt
    deletedBy = leader.deletedBy
}
