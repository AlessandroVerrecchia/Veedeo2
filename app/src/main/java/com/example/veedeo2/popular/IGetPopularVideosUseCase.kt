package com.example.veedeo2.popular

import com.example.pexels.model.Result
import com.example.pexels.model.VideoDTO

interface IGetPopularVideosUseCase {
    suspend fun execute(): Result<List<VideoDTO>>
}