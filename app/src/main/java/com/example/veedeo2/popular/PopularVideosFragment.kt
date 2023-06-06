package com.example.veedeo2.popular

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pexels.model.VideoDTO
import com.example.veedeo2.R
import com.example.veedeo2.ui.video.IVideoClickListener
import com.example.veedeo2.ui.video.VideoAdapter
import kotlinx.android.synthetic.main.fragment_popular_videos.popularVideosRecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularVideosFragment() : Fragment(), IVideoClickListener {

    private val popularVideosViewModel by viewModel<PopularVideosViewModel>()
    private  var videoAdapter: VideoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setupRecyclerView()

        observeFetchVideoResult()
        observeError()

        fetchPopularVideos()
    }

    private fun setupRecyclerView() {
        videoAdapter = VideoAdapter(this)
        popularVideosRecyclerView.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = videoAdapter
        }
    }

    private fun fetchPopularVideos() {
        popularVideosViewModel.fetchPopularVideos()
    }

    private fun observeFetchVideoResult() {
        popularVideosViewModel.videosLiveData.observe(viewLifecycleOwner, Observer { videos ->
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                if (videos.isEmpty()) {
                    Toast.makeText(context, "No popular videos", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    videoAdapter?.updateList(videos)
                }
            }
        })
    }

    private fun observeError() {
        popularVideosViewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onVideoClick(video: VideoDTO) {
        val action =
            PopularVideosFragmentDirections.actionPopularVideoFragmentToVideoPlayerFragment(video.videoFiles.first().link)
        view?.findNavController()?.navigate(action)

    }


}