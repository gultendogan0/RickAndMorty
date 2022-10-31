package com.gultendogan.rickandmorty.presentation.episode

import com.gultendogan.rickandmorty.domain.uimodel.EpisodeUIModel

interface EpisodeItemClickListener {
    fun onItemClickListener(episodeUIModel: EpisodeUIModel)
}