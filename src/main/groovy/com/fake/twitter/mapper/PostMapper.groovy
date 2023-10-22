package com.fake.twitter.mapper

import com.fake.twitter.model.dto.PostResponseDTO
import com.fake.twitter.model.entity.PostEntity

interface PostMapper {

    PostResponseDTO mapToResponseDto(PostEntity postEntity)

}