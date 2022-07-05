package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.LeaderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeaderEntityRepository: JpaRepository<LeaderEntity, Long> {
}
