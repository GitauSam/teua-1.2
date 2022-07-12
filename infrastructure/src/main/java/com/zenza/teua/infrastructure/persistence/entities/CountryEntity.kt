package com.zenza.teua.infrastructure.persistence.entities

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "countries")
class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @Column(nullable = false, length = 20)
    var name: String? = null

    @Column(nullable = false)
    var status: Int? = null

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime? = null

    @Column(name = "created_by", nullable = false, length = 255)
    var createdBy: String? = "admin"

    @LastModifiedDate
    @Column(name = "modified_at", nullable = false)
    var modifiedAt: LocalDateTime? = null

    @Column(name = "modified_by", nullable = false, length = 255)
    var modifiedBy: String = "admin"

    @Column(name = "deleted_by", length = 255)
    var deletedBy: String? = null

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
}