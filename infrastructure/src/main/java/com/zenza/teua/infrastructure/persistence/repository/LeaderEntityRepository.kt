package com.zenza.teua.infrastructure.persistence.repository

import com.zenza.teua.infrastructure.persistence.entities.LeaderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeaderEntityRepository: JpaRepository<LeaderEntity, Long> {
}
