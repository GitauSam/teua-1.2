package com.zenza.teua.infrastructure.persistence.adapters

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.ports.spi.CountryPersistencePort
import com.zenza.teua.infrastructure.persistence.mappers.countryEntityToCountryConverter
import com.zenza.teua.infrastructure.persistence.mappers.countryToCountryEntityConverter
import com.zenza.teua.infrastructure.persistence.repository.CountryEntityRepository
import org.springframework.stereotype.Service

@Service
class CountryEntityJpaAdapter(
    private val countryEntityRepository: CountryEntityRepository
): CountryPersistencePort {

    override fun createCountry(country: Country): Country {

        var countryEntity = countryToCountryEntityConverter(country)

        countryEntity = countryEntityRepository.save(countryEntity)

        val savedCountry = countryEntityToCountryConverter(countryEntity)

        return savedCountry!!
    }

    override fun getCountries(): List<Country?> {

        val countryEntities = countryEntityRepository.findAll()

        val countryList = mutableListOf<Country>()

        countryEntities.stream().map { ce -> countryList.add(countryEntityToCountryConverter(ce)!!) }

        return countryList
    }

    override fun getCountryById(countryId: Long): Country? {

        val countryEntity = countryEntityRepository.findById(countryId)

        return if (countryEntity.isPresent) {
            countryEntityToCountryConverter( countryEntity.get())
        } else {
            null
        }
    }
}
