package com.example.pexels.service

import com.example.pexels.model.Result
import com.example.pexels.model.VideoDTO

interface IPexelsApiService {
    suspend fun getPopularVideos(): Result<List<VideoDTO>>
}