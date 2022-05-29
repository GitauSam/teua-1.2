package com.zenza.teua.infrastructure.entities

import lombok.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
@ToString
data class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    val id: Long? = null,

    @Column(nullable = false, length = 350)
    var firstName: String? = null,

    @Column(nullable = false, length = 350)
    var lastName: String? = null,

    @Column(nullable = false, unique = true)
    var email: String? = null,

    @Column(nullable = false, unique = true, length = 350)
    var username: String? = null,

    @Column(nullable = false, unique = true, length = 12)
    var phoneNumber: String? = null,

    @Column(nullable = false)
    var password: String? = null,

    @Column(nullable = false)
    var status: Int = 0,

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "created_by", nullable = false, length = 255)
    var createdBy: String? = "admin",

    @LastModifiedDate
    @Column(name = "modified_at", nullable = false)
    var modifiedAt: LocalDateTime? = null,

    @Column(name = "modified_by", nullable = false, length = 255)
    var modifiedBy: String = "admin",

    @Column(name = "deleted_by", length = 255)
    var deletedBy: String? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
)
