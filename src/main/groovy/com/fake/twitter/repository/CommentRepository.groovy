package com.fake.twitter.repository

import com.fake.twitter.model.entity.CommentEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository extends MongoRepository<CommentEntity, String> {

}