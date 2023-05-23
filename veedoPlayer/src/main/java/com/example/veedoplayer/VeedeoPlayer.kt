package com.example.veedoplayer

import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class VeedeoPlayer(context: Context, private val videoUrl: String) {

    private var player = ExoPlayer.Builder(context).build()

    fun getPlayer() = player

    fun play(){
        val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    fun release(){
        player.release()
    }



}