package com.fake.twitter.service

import com.fake.twitter.model.dto.UserDTO

interface UserService {
    UserDTO createUser(UserDTO userRequestDto)

    UserDTO updateUser(String id, UserDTO userRequestDto)

    UserDTO getUser(String id)

    List<UserDTO> getUsers()

    void deleteUser(String id)
}