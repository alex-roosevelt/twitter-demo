package com.fake.twitter.service

import com.fake.twitter.model.dto.FavoritePostRequestDTO
import com.fake.twitter.model.dto.PostDTO
import com.fake.twitter.model.dto.PostResponseDTO

interface PostService {

    PostResponseDTO createPost(PostDTO postRequestDto)

    PostResponseDTO updatePost(String postId, PostDTO postRequestDto)

    PostResponseDTO getPostById(String postId)

    List<PostResponseDTO> getListPosts(String userId)

    void deletePost(String postId)

    void addFavoritePost(FavoritePostRequestDTO favoritePostRequest)

    void removeFavoritePost(String favoritePostId)
}