package com.fake.twitter.repository

import com.fake.twitter.model.entity.PostEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findAllByUserId(String userId)
}