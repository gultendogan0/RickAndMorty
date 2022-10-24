package com.gultendogan.rickandmorty.di

import com.gultendogan.rickandmorty.data.repo.AppRepository
import com.gultendogan.rickandmorty.data.repo.AppRepositoryImpl
import com.gultendogan.rickandmorty.retrofit.AppRemoteDao
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