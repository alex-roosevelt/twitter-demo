package com.fake.twitter.service

import com.fake.twitter.model.dto.PostDTO
import com.fake.twitter.model.dto.PostResponseDTO

interface PostService {

    PostResponseDTO createPost(PostDTO postRequestDto)

    PostResponseDTO updatePost(String postId, PostDTO postRequestDto)

    PostResponseDTO getPostById(String postId)

    List<PostResponseDTO> getListPosts()

    void deletePost(String postId)

}