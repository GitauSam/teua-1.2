package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.LeaderServicePort
import com.zenza.teua.domain.ports.spi.LeaderPersistencePort
import com.zenza.teua.domain.service.LeaderServiceImpl
import com.zenza.teua.domain.usecases.impl.leader.CreateLeaderUseCaseImpl
import com.zenza.teua.domain.usecases.impl.leader.GetAllLeaderUseCaseImpl
import com.zenza.teua.domain.usecases.impl.leader.GetLeaderByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.leader.CreateLeaderUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetAllLeadersUseCase
import com.zenza.teua.domain.usecases.interfaces.leader.GetLeaderByIdUseCase
import com.zenza.teua.infrastructure.persistence.adapters.LeaderEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.LeaderEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LeaderConfig {

    @Bean
    fun leaderPersistencePort(leaderEntityRepository: LeaderEntityRepository): LeaderPersistencePort {

        return LeaderEntityJpaAdapter(leaderEntityRepository)
    }

    @Bean
    fun createLeaderUseCase(leaderPersistencePort: LeaderPersistencePort): CreateLeaderUseCase {

        return CreateLeaderUseCaseImpl(leaderPersistencePort)
    }

    @Bean
    fun getAllLeadersUseCase(leaderPersistencePort: LeaderPersistencePort): GetAllLeadersUseCase {

        return GetAllLeaderUseCaseImpl(leaderPersistencePort)
    }

    @Bean
    fun getLeaderByIdUseCase(leaderPersistencePort: LeaderPersistencePort): GetLeaderByIdUseCase {

        return GetLeaderByIdUseCaseImpl(leaderPersistencePort)
    }

    @Bean
    fun leaderServicePort(leaderEntityRepository: LeaderEntityRepository): LeaderServicePort {

        return LeaderServiceImpl(
            createLeaderUseCase(leaderPersistencePort(leaderEntityRepository)),
            getLeaderByIdUseCase(leaderPersistencePort(leaderEntityRepository)),
            getAllLeadersUseCase(leaderPersistencePort(leaderEntityRepository))
        )
    }
}
