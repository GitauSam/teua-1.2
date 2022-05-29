package com.zenza.teua.application.controllers

import com.zenza.teua.domain.data.User
import com.zenza.teua.domain.ports.api.UserServicePort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userServicePort: UserServicePort
) {

    @PostMapping("/create")
    fun addUser(@RequestBody user: User): User {
        return userServicePort.addUser(user)!!
    }

    @GetMapping("/get/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userServicePort.getUserById(id)
    }

    @GetMapping("/get")
    fun getAllUsers(): List<User?> {
        return userServicePort.getUsers()
    }
}