package com.gultendogan.rickandmorty.presentation.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gultendogan.rickandmorty.R
import com.gultendogan.rickandmorty.databinding.FragmentEpisodeBinding
import com.gultendogan.rickandmorty.presentation.adapter.EpisodeAdapter
import com.gultendogan.rickandmorty.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class EpisodesFragment : Fragment(R.layout.fragment_episode) {
    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val viewModel: EpisodeViewModel by viewModels()
    private val mAdapter by lazy { EpisodeAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.episodeAdapter = mAdapter

        dropdownArrayAdapter()

        lifecycleScope.launch {
            viewModel.episodeList.collect{
                mAdapter.submitData(it)
            }
        }
    }

    private fun dropdownArrayAdapter() {
        viewModel.setHashMapSeasonAndEpisode()
        var episodeArrayAdapter : ArrayAdapter<String>
        val seasonArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_season_item, viewModel.seasonListHashMap)
        binding.autoCompleteSeason.setText(R.string.select_season)
        binding.autoCompleteEpisode.setText(R.string.select_episode)
        binding.autoCompleteSeason.setAdapter(seasonArrayAdapter)
        binding.autoCompleteSeason.setOnItemClickListener { _, _, i, _ ->
            if(viewModel.episodeListHashMap.contains("Episode 11")){
                viewModel.episodeListHashMap.remove("Episode 11")
            }
            episodeArrayAdapter = if(seasonArrayAdapter.getItem(i) == "Season 1"){
                viewModel.episodeListHashMap.add("Episode 11")
                ArrayAdapter(requireContext(), R.layout.dropdown_episode_item, viewModel.episodeListHashMap)
            }else{
                ArrayAdapter(requireContext(), R.layout.dropdown_episode_item, viewModel.episodeListHashMap)
            }
            binding.autoCompleteEpisode.setAdapter(episodeArrayAdapter)
        }
    }

    override fun onStart() {
        super.onStart()
        dropdownArrayAdapter()
    }
}
