package com.fake.twitter.mapper

import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.model.entity.UserEntity

interface UserMapper {

    UserDTO userMapToDto(UserEntity userEntity)
}
