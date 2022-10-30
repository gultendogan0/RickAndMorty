package com.gultendogan.rickandmorty.data.repo

import androidx.paging.PagingData
import com.gultendogan.rickandmorty.data.entities.Character.Character
import com.gultendogan.rickandmorty.data.entities.Character.CharacterResponse
import com.gultendogan.rickandmorty.data.entities.episode.Episode
import com.gultendogan.rickandmorty.data.entities.episode.EpisodeResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getCharacters(): Flow<PagingData<Character>>

    suspend fun getAllEpisodes(): Flow<PagingData<Episode>>

    suspend fun getFilterCharacters(filterQuery: Map<String,String>): Flow<PagingData<Character>>

    suspend fun getFilterEpisodes(filter: String): Flow<PagingData<Episode>>

    suspend fun getCharactersNetworkResult(pageNumber : Int) : CharacterResponse

    suspend fun getEpisodesNetworkResult(pageNumber : Int) : EpisodeResponse
}