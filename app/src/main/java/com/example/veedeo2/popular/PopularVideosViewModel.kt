package com.example.veedeo2.popular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexels.model.Status
import com.example.pexels.model.VideoDTO
import kotlinx.coroutines.launch

class PopularVideosViewModel(private val getPopularVideosUseCase: IGetPopularVideosUseCase) : ViewModel() {
    val videosLiveData = MutableLiveData<List<VideoDTO>>()
    val errorLiveData = MutableLiveData<String?>()

    fun fetchPopularVideos() {
        viewModelScope.launch {
            val result = getPopularVideosUseCase.execute()
            if (result.status == Status.SUCCESS) {
                result.data?.let {
                    videosLiveData.value = it
                }
            } else {
                errorLiveData.value = result.message
            }
        }
    }
}