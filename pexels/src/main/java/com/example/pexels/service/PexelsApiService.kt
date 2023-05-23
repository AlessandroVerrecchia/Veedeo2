package com.example.pexels.service

import android.util.Log
import com.example.pexels.model.Result
import com.example.pexels.model.Status
import com.example.pexels.model.VideoDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PexelsApiService(private val pexelsApi: IPexelsApi) : IPexelsApiService {
    override suspend  fun getPopularVideos(): Result<List<VideoDTO>> {
        return withContext(Dispatchers.IO) {
            try {
                Result(
                    Status.SUCCESS,
                    pexelsApi.popular().body()?.videos,
                    null
                )
            } catch (e: Exception) {
                e.message?.let { Log.e("popular", it) }
                Result(Status.ERROR, null, e.message ?: "Error Fetching Popular videos")
            }
        }
    }
}