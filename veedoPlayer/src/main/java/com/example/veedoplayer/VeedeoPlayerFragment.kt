package com.example.veedoplayer

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_video.VeedeoPlayerView

class VeedeoPlayerFragment : Fragment() {

    lateinit var veedeoPlayer: VeedeoPlayer
    lateinit var videoUri: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            videoUri = it.getString("videoUri", "")
        }
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        setupPlayer()
    }

    private fun setupPlayer() {
        context?.let {
            veedeoPlayer = VeedeoPlayer(it, videoUri)
            VeedeoPlayerView.player = veedeoPlayer.getPlayer()
            veedeoPlayer.play()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        veedeoPlayer.release()
    }

    override fun onDetach() {
        super.onDetach()
        veedeoPlayer.release()
    }

}