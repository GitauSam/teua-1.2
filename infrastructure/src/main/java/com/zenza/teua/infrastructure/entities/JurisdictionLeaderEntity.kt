package com.zenza.teua.infrastructure.entities

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "jurisdiction_leaders")
class JurisdictionLeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "leader_id", referencedColumnName = "id")
    var leader: LeaderEntity? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "jurisdiction_title_id", referencedColumnName = "id")
    var jurisdictionTitle: JurisdictionTitleEntity? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    var country: CountryEntity? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "county_id", referencedColumnName = "id")
    var county: CountyEntity? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ward_id", referencedColumnName = "id")
    var ward: WardEntity? = null

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