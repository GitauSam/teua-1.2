package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.JurisdictionLeaderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JurisdictionLeaderEntityRepository: JpaRepository<JurisdictionLeaderEntity, Long> {
}
