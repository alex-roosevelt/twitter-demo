package com.fake.twitter.repository

import com.fake.twitter.model.entity.FavoritePostEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoritePostRepository extends MongoRepository<FavoritePostEntity, String>{

}