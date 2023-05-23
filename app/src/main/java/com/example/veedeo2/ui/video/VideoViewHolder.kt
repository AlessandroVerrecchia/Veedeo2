package com.example.veedeo2.ui.video

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_item.view.container
import kotlinx.android.synthetic.main.video_item.view.videoDuration
import kotlinx.android.synthetic.main.video_item.view.videoThumbnail
import kotlinx.android.synthetic.main.video_item.view.videoTitle


class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val container: ConstraintLayout = itemView.container
    val thumbnail: ImageView = itemView.videoThumbnail
    val title: TextView = itemView.videoTitle
    val duration: TextView = itemView.videoDuration
}