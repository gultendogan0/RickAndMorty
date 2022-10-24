package com.gultendogan.rickandmorty.retrofit

import com.gultendogan.rickandmorty.data.entities.Character.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppRemoteDao {

    @GET("character")
    suspend fun getAllCharacters(@Query("page") query:Int) : Response<CharacterResponse>
}