package com.gultendogan.rickandmorty.data.di

import com.gultendogan.rickandmorty.domain.repo.AppRepository
import com.gultendogan.rickandmorty.domain.repo.AppRepositoryImpl
import com.gultendogan.rickandmorty.data.retrofit.AppRemoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAppRepository(remoteDao: AppRemoteDao) = AppRepositoryImpl(remoteDao) as AppRepository
}