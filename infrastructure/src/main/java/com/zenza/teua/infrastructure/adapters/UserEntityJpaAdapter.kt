package com.zenza.teua.infrastructure.adapters

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.spi.UserPersistencePort
import com.zenza.teua.infrastructure.mappers.toUser
import com.zenza.teua.infrastructure.mappers.toUserEntity
import com.zenza.teua.infrastructure.mappers.toUserList
import com.zenza.teua.infrastructure.repository.UserEntityRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserEntityJpaAdapter(
    private val userEntityRepository: UserEntityRepository
): UserPersistencePort {

    override fun addUser(user: User): User? {
        val userEntity = user.toUserEntity()

        val userEntitySaved = userEntityRepository
                                .save(
                                    userEntity
                                        .apply {
                                        createdAt = LocalDateTime.now()
                                        modifiedAt = LocalDateTime.now()
                                    }
                                )

        return userEntitySaved.toUser()
    }

    override fun getUserById(userId: Long): User? {

        val userEntity = userEntityRepository.findById(userId)

        return if (userEntity.isPresent) userEntity.get().toUser() else null
    }

    override fun getUsers(): List<User> {

        val userEntities = userEntityRepository.findAll()

        return toUserList(userEntities)
    }
}
