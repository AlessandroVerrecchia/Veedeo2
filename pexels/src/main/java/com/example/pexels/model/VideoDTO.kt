package com.example.pexels.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoContainer(
    @Expose
    var page: String,
    @Expose
    @SerializedName("total_results")
    var totalResult: Long,
    @Expose
    var videos: List<VideoDTO>
) : Parcelable

@Parcelize
data class VideoDTO(
    @Expose
    var id: Long,
    @Expose
    var width: Long,
    @Expose
    var height: Long,
    @Expose
    var url: String,
    @Expose
    var duration: Long,
    @Expose
    var image: String,
    @Expose
    @SerializedName("video_files")
    var videoFiles: List<VideoFile>
) : Parcelable

@Parcelize
data class VideoFile(
    var id: Long,
    var quality: String,
    var fileType: String,
    var width: Long,
    var height: Long,
    var link: String,
) : Parcelable