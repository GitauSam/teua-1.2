package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository: JpaRepository<UserEntity, Long> {
}