package com.fake.twitter.repository

import com.fake.twitter.model.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findByIdIn(List<String> userIds)

    Optional<UserEntity> findByUsername(String username)
}