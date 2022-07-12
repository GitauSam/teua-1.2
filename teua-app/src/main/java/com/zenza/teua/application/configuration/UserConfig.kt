package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.UserServicePort
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import com.zenza.teua.domain.service.UserServiceImpl
import com.zenza.teua.domain.usecases.impl.users.CreateUserUseCaseImpl
import com.zenza.teua.domain.usecases.impl.users.GetAllUsersUseCaseImpl
import com.zenza.teua.domain.usecases.impl.users.GetUserByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.users.CreateUserUseCase
import com.zenza.teua.domain.usecases.interfaces.users.GetAllUsersUseCase
import com.zenza.teua.domain.usecases.interfaces.users.GetUserByIdUseCase
import com.zenza.teua.infrastructure.persistence.adapters.UserEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.UserEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserConfig {

    @Bean
    fun userPersistencePort(userEntityRepository: UserEntityRepository): UserPersistencePort {
        return UserEntityJpaAdapter(userEntityRepository)
    }

    @Bean
    fun createUserUseCase(userPersistencePort: UserPersistencePort): CreateUserUseCase {
        return CreateUserUseCaseImpl(userPersistencePort)
    }

    @Bean
    fun getAllUsersUseCase(userPersistencePort: UserPersistencePort): GetAllUsersUseCase {
        return GetAllUsersUseCaseImpl(userPersistencePort)
    }

    @Bean
    fun getUserByIdUseCase(userPersistencePort: UserPersistencePort): GetUserByIdUseCase {
        return GetUserByIdUseCaseImpl(userPersistencePort)
    }

    @Bean
    fun userServicePort(userEntityRepository: UserEntityRepository): UserServicePort {
        return UserServiceImpl(
            createUserUseCase(userPersistencePort(userEntityRepository)),
            getAllUsersUseCase(userPersistencePort(userEntityRepository)),
            getUserByIdUseCase(userPersistencePort(userEntityRepository))
        )
    }
}