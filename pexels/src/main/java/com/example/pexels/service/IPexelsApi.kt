package com.example.pexels.service

import com.example.pexels.model.VideoContainer
import retrofit2.Response
import retrofit2.http.GET

interface IPexelsApi {

    @GET("popular")
    suspend fun popular(): Response<VideoContainer>

}