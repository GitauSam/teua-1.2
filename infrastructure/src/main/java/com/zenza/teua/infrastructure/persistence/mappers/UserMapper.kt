package com.zenza.teua.infrastructure.persistence.mappers

import com.zenza.teua.domain.data.User
import com.zenza.teua.infrastructure.persistence.entities.UserEntity

fun User.toUserEntity() = UserEntity(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    username = username,
    phoneNumber = phoneNumber,
    password = password,
    status = status!!,
    createdAt = createdAt,
    createdBy = createdBy,
    modifiedAt = modifiedAt,
    modifiedBy = modifiedBy!!,
    deletedBy = deletedBy,
    deletedAt = deletedAt
)

fun UserEntity.toUser() = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    username = username,
    phoneNumber = phoneNumber,
    password = password,
    status = status,
    createdAt = createdAt,
    createdBy = createdBy,
    modifiedAt = modifiedAt,
    modifiedBy = modifiedBy,
    deletedBy = deletedBy,
    deletedAt = deletedAt
)

fun toUserEntityList(users: List<User>) = run {
    val userEntities = mutableListOf<UserEntity>()

    for (user in users) {
        userEntities.add(user.toUserEntity())
    }

    userEntities
}

fun toUserList(userEntities: List<UserEntity>) = run {
    val users = mutableListOf<User>()

    for (userEntity in userEntities) {
        users.add(userEntity.toUser())
    }

    users
}