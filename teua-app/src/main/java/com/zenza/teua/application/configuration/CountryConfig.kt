package com.zenza.teua.application.configuration

import com.zenza.teua.domain.ports.api.CountryServicePort
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import com.zenza.teua.domain.service.CountryServiceImpl
import com.zenza.teua.domain.usecases.impl.country.CreateCountryUseCaseImpl
import com.zenza.teua.domain.usecases.impl.country.GetAllCountriesUseCaseImpl
import com.zenza.teua.domain.usecases.impl.country.GetCountryByIdUseCaseImpl
import com.zenza.teua.domain.usecases.interfaces.country.CreateCountryUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetAllCountriesUseCase
import com.zenza.teua.domain.usecases.interfaces.country.GetCountryByIdUseCase
import com.zenza.teua.infrastructure.persistence.adapters.CountryEntityJpaAdapter
import com.zenza.teua.infrastructure.persistence.repository.CountryEntityRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CountryConfig {

    @Bean
    fun countryPersistencePort(countryEntityRepository: CountryEntityRepository): CountryPersistencePort {

        return CountryEntityJpaAdapter(countryEntityRepository)
    }

    @Bean
    fun createCountryUseCase(countryPersistencePort: CountryPersistencePort): CreateCountryUseCase {

        return CreateCountryUseCaseImpl(countryPersistencePort)
    }

    @Bean
    fun getCountryByIdUseCase(countryPersistencePort: CountryPersistencePort): GetCountryByIdUseCase {

        return GetCountryByIdUseCaseImpl(countryPersistencePort)
    }

    @Bean
    fun getAllCountriesUseCase(countryPersistencePort: CountryPersistencePort): GetAllCountriesUseCase {

        return GetAllCountriesUseCaseImpl(countryPersistencePort)
    }

    @Bean
    fun countryServicePort(countryEntityRepository: CountryEntityRepository): CountryServicePort {

        return CountryServiceImpl(
            createCountryUseCase(countryPersistencePort(countryEntityRepository)),
            getCountryByIdUseCase(countryPersistencePort(countryEntityRepository)),
            getAllCountriesUseCase(countryPersistencePort(countryEntityRepository))
        )
    }
}
