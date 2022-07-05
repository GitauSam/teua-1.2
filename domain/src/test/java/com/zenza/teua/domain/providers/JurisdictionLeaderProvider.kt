package com.zenza.teua.domain.providers

import com.zenza.teua.domain.data.Country
import com.zenza.teua.domain.data.JurisdictionLeader
import com.zenza.teua.domain.data.JurisdictionTitle
import com.zenza.teua.domain.data.Leader
import io.github.serpro69.kfaker.faker
import java.time.LocalDateTime

class JurisdictionLeaderProvider {

    companion object {

        private val faker = faker {  }

        fun buildJurisdictionLeader(): JurisdictionLeader {

            return JurisdictionLeader()
                .apply {
                    status = 1
                    createdAt = LocalDateTime.now()
                    createdBy = "admin"
                    modifiedAt = LocalDateTime.now()
                    modifiedBy = "admin"
                    jurisdictionTitle = JurisdictionTitle().apply {
                        id = 1
                        title = "President"
                        status = 1
                        createdAt = LocalDateTime.now()
                        createdBy = "admin"
                        modifiedAt = LocalDateTime.now()
                        modifiedBy = "admin"
                    }
                    leader = Leader().apply {
                        id = 1
                        firstName = faker.name.firstName()
                        middleName = faker.name.nameWithMiddle()
                        lastName = faker.name.lastName()
                        dateOfBirth = LocalDateTime.now()
                        status = 1
                    }
                    country = Country().apply {
                        id = 1
                        name = faker.random.randomString(12)
                        status = 1
                    }
                }
        }
    }
}
