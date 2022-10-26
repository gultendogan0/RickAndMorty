package com.gultendogan.rickandmorty.domain.repo

import androidx.paging.PagingData
import com.gultendogan.rickandmorty.data.entities.Character.Character
import com.gultendogan.rickandmorty.data.entities.Character.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getCharacters(): Flow<PagingData<Character>>
    suspend fun getCharactersNetworkResult(pageNumber : Int) : CharacterResponse
}