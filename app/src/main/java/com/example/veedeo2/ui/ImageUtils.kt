package com.example.veedeo2.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.veedeo2.R

fun loadImage(imageView: ImageView?, url: String?) {
    imageView ?: return
    Glide.with(imageView.context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.video_icon)
        .into(imageView)
}