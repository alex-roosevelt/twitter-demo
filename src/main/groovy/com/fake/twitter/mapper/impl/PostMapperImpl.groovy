package com.fake.twitter.mapper.impl

import com.fake.twitter.mapper.PostMapper
import com.fake.twitter.model.dto.PostResponseDTO
import com.fake.twitter.model.entity.PostEntity
import org.springframework.stereotype.Component

@Component
class PostMapperImpl implements PostMapper{

    @Override
    PostResponseDTO mapToResponseDto(PostEntity postEntity) {
        PostResponseDTO postResponseDTO = new PostResponseDTO()
        postResponseDTO.id = postEntity.id
        postResponseDTO.userId = postEntity.userId
        postResponseDTO.post = postEntity.post
        postResponseDTO.createdPost = postEntity.createdPost
        postResponseDTO.editedPost = postEntity.editedPost
        return postResponseDTO
    }
}
