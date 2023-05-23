package com.example.veedeo2.ui.video

import com.example.pexels.model.VideoDTO

interface IVideoClickListener {
    fun onClick(video: VideoDTO)
}