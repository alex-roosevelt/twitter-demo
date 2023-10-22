package com.fake.twitter.mapper.impl

import com.fake.twitter.mapper.UserMapper
import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.model.entity.UserEntity
import com.fake.twitter.model.enums.SexEnum
import org.springframework.stereotype.Component

@Component
class UserMapperImpl implements UserMapper{

    @Override
    UserDTO userMapToDto(UserEntity userEntity) {
        UserDTO userResponse = new UserDTO()
        userResponse.id = userEntity.id
        userResponse.firstName = userEntity.firstName
        userResponse.lastName = userEntity.lastName
        userResponse.userName = userEntity.username
        userResponse.city = userEntity.city
        userResponse.country = userEntity.country
        userResponse.sex = userEntity.sex in ['MALE', 'FEMALE', 'OTHER'] ? userEntity.sex as SexEnum : null
        userResponse.email = userEntity.email
        userResponse.password = userEntity.password
        return userResponse
    }
}
