package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.CountyServicePort
import com.zenza.teua.domain.ports.spi.CountyPersistencePort
import com.zenza.teua.domain.service.CountyServiceImpl
import com.zenza.teua.domain.usecases.impl.county.CreateCountyUseCaseImpl
import com.zenza.teua.domain.usecases.impl.county.GetAllCountiesUseCaseImpl
import com.zenza.teua.domain.usecases.impl.county.GetCountyByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.county.CreateCountyUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetAllCountiesUseCase
import com.zenza.teua.domain.usecases.interfaces.county.GetCountyByIdUseCase
import com.zenza.teua.infrastructure.persistence.adapters.CountyEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.CountyEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CountyConfig {

    @Bean
    fun countyPersistencePort(countyEntityRepository: CountyEntityRepository): CountyPersistencePort {

        return CountyEntityJpaAdapter(countyEntityRepository)
    }

    @Bean
    fun createCountyUseCase(countyPersistencePort: CountyPersistencePort): CreateCountyUseCase {

        return CreateCountyUseCaseImpl(countyPersistencePort)
    }

    @Bean
    fun getCountyByIdUseCase(countyPersistencePort: CountyPersistencePort): GetCountyByIdUseCase {

        return GetCountyByIdUseCaseImpl(countyPersistencePort)
    }

    @Bean
    fun getAllCountiesUseCase(countyPersistencePort: CountyPersistencePort): GetAllCountiesUseCase {

        return GetAllCountiesUseCaseImpl(countyPersistencePort)
    }

    @Bean
    fun countyServicePort(countyEntityRepository: CountyEntityRepository): CountyServicePort {

        return CountyServiceImpl(
            createCountyUseCase(countyPersistencePort(countyEntityRepository)),
            getCountyByIdUseCase(countyPersistencePort(countyEntityRepository)),
            getAllCountiesUseCase(countyPersistencePort(countyEntityRepository))
        )
    }
}
