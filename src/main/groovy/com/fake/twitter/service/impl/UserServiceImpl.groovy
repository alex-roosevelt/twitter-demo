package com.fake.twitter.service.impl

import com.fake.twitter.mapper.UserMapper
import com.fake.twitter.model.dto.UserDTO
import com.fake.twitter.model.entity.UserEntity
import com.fake.twitter.repository.UserRepository
import com.fake.twitter.service.UserService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository
    private final UserMapper userMapper
    private final BCryptPasswordEncoder bCryptPasswordEncoder

    UserServiceImpl(UserRepository userRepository,
                    UserMapper userMapper,
                    BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository
        this.userMapper = userMapper
        this.bCryptPasswordEncoder = bCryptPasswordEncoder
    }

    @Override
    UserDTO createUser(UserDTO userRequestDto) {
        UserEntity userEntity = new UserEntity()
        userEntity.firstName = userRequestDto.firstName
        userEntity.lastName = userRequestDto.lastName
        userEntity.username = userRequestDto.userName
        userEntity.city = userRequestDto.city
        userEntity.country = userRequestDto.country
        userEntity.sex = userRequestDto.sex.toString()
        userEntity.email = userRequestDto.email
        userEntity.password = bCryptPasswordEncoder.encode(userRequestDto.password)
        UserEntity saveUser = userRepository.save(userEntity)
        return userMapper.userMapToDto(saveUser)
    }

    @Override
    UserDTO updateUser(String id, UserDTO userRequestDto) {

        Optional<UserEntity> userEntity = userRepository.findById(id)
        if (userEntity.isEmpty()) {
            return null
        } else {
            userEntity.get().firstName = userRequestDto.firstName
            userEntity.get().lastName = userRequestDto.lastName
            userEntity.get().username = userRequestDto.userName
            userEntity.get().city = userRequestDto.city
            userEntity.get().country = userRequestDto.country
            userEntity.get().sex = userRequestDto.sex.toString()
            userEntity.get().email = userRequestDto.email
            userEntity.get().password = bCryptPasswordEncoder.encode(userRequestDto.password)
            UserEntity saveUser = userRepository.save(userEntity.get())
            return userMapper.userMapToDto(saveUser)
        }
    }

    @Override
    UserDTO getUser(String id) {
        userRepository.findById(id)
                .map { userMapper.userMapToDto(it) }
                .orElse(null)
    }


    @Override
    List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map { it -> userMapper.userMapToDto(it) }
                .collect()
    }

    @Override
    void deleteUser(String id) {
        userRepository.deleteById(id)
    }
}
