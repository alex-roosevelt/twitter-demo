package com.fake.twitter.controller

import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.service.UserService
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = "контролер реєстрації")
@RequestMapping("/api/v1/registration")
class RegistrationController {

    private final UserService userService

    RegistrationController(UserService userService) {
        this.userService = userService
    }

    // register user
    @Operation(summary = "реєстрація користувача")
    @PostMapping
    ResponseEntity<UserDTO> registrationUser(@RequestBody UserDTO request){
        return ResponseEntity.ok(userService.createUser(request))
    }
}
