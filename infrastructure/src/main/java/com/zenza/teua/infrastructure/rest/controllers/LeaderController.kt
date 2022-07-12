package com.zenza.teua.infrastructure.rest.controllers

import com.google.common.base.Preconditions
import com.zenza.teua.domain.data.Leader
import com.zenza.teua.domain.ports.api.LeaderServicePort
import com.zenza.teua.infrastructure.rest.converters.LeaderFactory
import com.zenza.teua.infrastructure.rest.request.CreateLeaderRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/leader")
class LeaderController {

    @Autowired
    private val leaderServicePort: LeaderServicePort? = null

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createLeader(@Valid @RequestBody createLeaderRequest: CreateLeaderRequest): Leader {

        Preconditions.checkNotNull(createLeaderRequest)

        val leader = LeaderFactory.buildLeader(createLeaderRequest)

        return leaderServicePort!!.createLeader(leader)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllLeaders(): List<Leader> {

        return leaderServicePort!!.getLeaders()
    }

    @GetMapping("/{leader-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getLeaderById(@PathVariable("leader-id") leaderId: Long): Leader? {

        return leaderServicePort!!.getLeaderById(leaderId)
    }
}
