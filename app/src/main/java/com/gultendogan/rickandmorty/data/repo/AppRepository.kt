package com.gultendogan.rickandmorty.data.repo

import androidx.paging.PagingData
import com.gultendogan.rickandmorty.data.entities.Character.Character
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getCharacters(): Flow<PagingData<Character>>
}