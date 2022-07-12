package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.JurisdictionTitleServicePort
import com.zenza.teua.domain.ports.spi.JurisdictionTitlePersistencePort
import com.zenza.teua.domain.service.JurisdictionTitleServiceImpl
import com.zenza.teua.domain.usecases.impl.jurisdictiontitle.CreateJurisdictionTitleUseCaseImpl
import com.zenza.teua.domain.usecases.impl.jurisdictiontitle.GetAllJurisdictionTitlesUseCaseImpl
import com.zenza.teua.domain.usecases.impl.jurisdictiontitle.GetJurisdictionTitleByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.CreateJurisdictionTitleUseCase
import com.zenza.teua.domain.usecases.interfaces.jurisdictiontitle.GetAllJurisdictionTitlesUseCase
import com.zenza.teua.infrastructure.persistence.adapters.JurisdictionTitleEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.JurisdictionTitleEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JurisdictionTitleConfig {

    @Bean
    fun jurisdictionTitlePersistencePort(jurisdictionTitleEntityRepository: JurisdictionTitleEntityRepository): JurisdictionTitlePersistencePort {

        return JurisdictionTitleEntityJpaAdapter(jurisdictionTitleEntityRepository)
    }

    @Bean
    fun createJurisdictionTitleUseCase(jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort): CreateJurisdictionTitleUseCase {

        return CreateJurisdictionTitleUseCaseImpl(jurisdictionTitlePersistencePort)
    }

    @Bean
    fun getAllJurisdictionTitlesUseCase(jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort): GetAllJurisdictionTitlesUseCase {

        return GetAllJurisdictionTitlesUseCaseImpl(jurisdictionTitlePersistencePort)
    }

    @Bean
    fun getJurisdictionTitleByIdUseCase(jurisdictionTitlePersistencePort: JurisdictionTitlePersistencePort): GetJurisdictionTitleByIdUseCaseImpl {

        return GetJurisdictionTitleByIdUseCaseImpl(jurisdictionTitlePersistencePort)
    }

    @Bean
    fun jurisdictionTitleServicePort(jurisdictionTitleEntityRepository: JurisdictionTitleEntityRepository): JurisdictionTitleServicePort {

        return JurisdictionTitleServiceImpl(
            createJurisdictionTitleUseCase(jurisdictionTitlePersistencePort(jurisdictionTitleEntityRepository)),
            getJurisdictionTitleByIdUseCase(jurisdictionTitlePersistencePort(jurisdictionTitleEntityRepository)),
            getAllJurisdictionTitlesUseCase(jurisdictionTitlePersistencePort(jurisdictionTitleEntityRepository))
        )
    }
}
