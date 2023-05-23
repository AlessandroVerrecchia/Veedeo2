package com.example.veedeo2.popular

import com.example.pexels.model.Result
import com.example.pexels.model.VideoDTO
import com.example.pexels.service.IPexelsApiService

class GetPopularVideosUseCase(private val pexelsApiService: IPexelsApiService) :
    IGetPopularVideosUseCase {

    override suspend fun execute(): Result<List<VideoDTO>> {
        return pexelsApiService.getPopularVideos()
    }
}