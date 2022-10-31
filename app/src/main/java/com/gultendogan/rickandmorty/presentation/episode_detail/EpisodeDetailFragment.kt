package com.gultendogan.rickandmorty.presentation.episode_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.gultendogan.rickandmorty.R
import com.gultendogan.rickandmorty.databinding.FragmentEpisodeDetailBinding
import com.gultendogan.rickandmorty.presentation.adapter.EpisodeCharacterAdapter
import com.gultendogan.rickandmorty.utils.actionFragment
import com.gultendogan.rickandmorty.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val viewModel : EpisodeDetailViewModel by viewModels()
    private val navArgs : EpisodeDetailFragmentArgs by navArgs()
    private lateinit var mAdapter : EpisodeCharacterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar = "Episode Detail"
        binding.episode = navArgs.episode
        toolbarBackIconClicked()
        viewModel.getCharacterUrlList(navArgs.episode.characters)
        episodeCharacterListCollect()

    }

    private fun toolbarBackIconClicked(){
        binding.toolbarEpisodeDetail.setNavigationOnClickListener {
            Navigation.actionFragment(requireView(),EpisodeDetailFragmentDirections.actionEpisodeDetailFragmentToEpisodesFragment())
        }
    }

    private fun episodeCharacterListCollect(){
        lifecycleScope.launch {
            viewModel.episodeCharacterList.collectLatest {
                mAdapter = EpisodeCharacterAdapter(it)
                binding.rvEpisodeDetail.adapter = mAdapter
            }
        }
    }
}