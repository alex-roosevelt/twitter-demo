package com.fake.twitter.controller

import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    private final UserService userService

    UserController(UserService userService) {
        this.userService = userService
    }

    // create user
    @PostMapping("/create")
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO request) {
        return ResponseEntity.ok(userService.createUser(request))
    }

    // update user
    @PutMapping("/update/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO request) {
        return ResponseEntity.ok(userService.updateUser(id, request))
    }

    // get user by id
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(id))
    }

    // get list users
    @GetMapping("/list")
    ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers())
    }
    // delete user
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id))
    }

}
