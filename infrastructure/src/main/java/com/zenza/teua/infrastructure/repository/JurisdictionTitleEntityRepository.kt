package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.JurisdictionTitleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JurisdictionTitleEntityRepository: JpaRepository<JurisdictionTitleEntity, Int> {
}
