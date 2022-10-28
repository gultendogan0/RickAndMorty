package com.gultendogan.rickandmorty.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gultendogan.rickandmorty.data.entities.Character.Character
import com.gultendogan.rickandmorty.data.entities.Character.CharacterResponse
import com.gultendogan.rickandmorty.data.repo.pagingsource.CharacterPagingSource
import com.gultendogan.rickandmorty.data.repo.pagingsource.FilterCharacterPagingSource
import com.gultendogan.rickandmorty.data.retrofit.AppRemoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(var remoteDao: AppRemoteDao) : AppRepository {
    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(42),
            pagingSourceFactory = { CharacterPagingSource(remoteDao)}).flow
    }

    override suspend fun getFilterCharacters(filterQuery: Map<String, String>): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(20),
            pagingSourceFactory = { FilterCharacterPagingSource(remoteDao,filterQuery)}).flow
    }

    override suspend fun getCharactersNetworkResult(pageNumber: Int): CharacterResponse {
        return remoteDao.getAllCharacters(pageNumber)
    }
}