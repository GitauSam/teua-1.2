package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.CountyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountyEntityRepository: JpaRepository<CountyEntity, Long> {
}
