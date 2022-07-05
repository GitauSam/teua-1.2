package com.zenza.teua.infrastructure.repository

import com.zenza.teua.infrastructure.entities.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryEntityRepository: JpaRepository<CountryEntity, Long> {
}
