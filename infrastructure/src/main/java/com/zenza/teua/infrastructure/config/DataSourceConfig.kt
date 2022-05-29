package com.zenza.teua.infrastructure.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["com.zenza.teua.infrastructure.repository"])
@EntityScan(basePackages = ["com.zenza.teua.infrastructure.entities"])
class DataSourceConfig {

    @Bean
    fun dataSource(): DataSource {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.postgresql.Driver")
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/teua")
        dataSourceBuilder.username("postgres")
        dataSourceBuilder.password("postgres")

        return dataSourceBuilder.build()
    }
}