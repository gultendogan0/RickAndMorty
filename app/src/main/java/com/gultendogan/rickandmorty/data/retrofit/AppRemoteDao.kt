package com.gultendogan.rickandmorty.data.retrofit

import com.gultendogan.rickandmorty.data.entities.Character.Character
import com.gultendogan.rickandmorty.data.entities.Character.CharacterResponse
import com.gultendogan.rickandmorty.data.entities.episode.EpisodeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AppRemoteDao {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") query: Int): CharacterResponse

    @GET("episode")
    suspend fun getAllEpisodes(@Query("page") query: Int): EpisodeResponse

    @GET("character")
    suspend fun getFilterCharacters(@Query("page") query: Int, @QueryMap filterQuery: Map<String, String>): CharacterResponse

    @GET("episode")
    suspend fun getFilterEpisodes(@Query("page") query: Int, @Query("episode") filter: String): EpisodeResponse

    @GET("character/{ids}")
    suspend fun getCharacterByIdList(@Path("ids") ids: String): List<Character>
}