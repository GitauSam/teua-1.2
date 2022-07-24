package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.WardServicePort
import com.zenza.teua.domain.ports.spi.WardPersistencePort
import com.zenza.teua.domain.service.WardServiceImpl
import com.zenza.teua.domain.usecases.impl.ward.CreateWardUseCaseImpl
import com.zenza.teua.domain.usecases.impl.ward.GetAllWardsUseCaseImpl
import com.zenza.teua.domain.usecases.impl.ward.GetWardByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.ward.CreateWardUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetAllWardsUseCase
import com.zenza.teua.domain.usecases.interfaces.ward.GetWardByIdUseCase
import com.zenza.teua.infrastructure.persistence.adapters.WardEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.WardEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WardConfig {

    @Bean
    fun wardPersistencePort(wardEntityRepository: WardEntityRepository): WardPersistencePort {

        return WardEntityJpaAdapter(wardEntityRepository)
    }

    @Bean
    fun createWardUseCase(wardPersistencePort: WardPersistencePort): CreateWardUseCase {

        return CreateWardUseCaseImpl(wardPersistencePort)
    }

    @Bean
    fun getWardByIdUseCase(wardPersistencePort: WardPersistencePort): GetWardByIdUseCase {

        return GetWardByIdUseCaseImpl(wardPersistencePort)
    }

    @Bean
    fun getAllWardsUseCase(wardPersistencePort: WardPersistencePort): GetAllWardsUseCase {

        return GetAllWardsUseCaseImpl(wardPersistencePort)
    }

    @Bean
    fun wardServicePort(wardEntityRepository: WardEntityRepository): WardServicePort {

        return WardServiceImpl(
            createWardUseCase(wardPersistencePort(wardEntityRepository)),
            getWardByIdUseCase(wardPersistencePort(wardEntityRepository)),
            getAllWardsUseCase(wardPersistencePort(wardEntityRepository))
        )
    }
}
