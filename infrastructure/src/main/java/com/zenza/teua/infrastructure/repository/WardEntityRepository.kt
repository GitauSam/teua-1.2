package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.WardEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WardEntityRepository: JpaRepository<WardEntity, Long> {
}
