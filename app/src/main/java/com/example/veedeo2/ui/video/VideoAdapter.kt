package com.example.veedeo2.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pexels.model.VideoDTO
import com.example.veedeo2.R
import com.example.veedeo2.ui.loadImage

class VideoAdapter(private var onVideoClickListener: IVideoClickListener) :
    RecyclerView.Adapter<VideoViewHolder>() {

    private var videos = listOf<VideoDTO>()

    fun updateList(videos: List<VideoDTO>){
        this.videos = videos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.apply {
            container.setOnClickListener {
                onVideoClickListener.onVideoClick(video)
            }
            title.text = "${video.id}"
            duration.text = "${video.duration} sec"
            loadImage(thumbnail, video.image)
        }
    }

    override fun getItemCount(): Int = videos.size
}