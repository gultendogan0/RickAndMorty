package com.gultendogan.rickandmorty.data.entities.entities.episode

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val episodes: List<Episode>
)