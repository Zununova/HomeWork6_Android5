package com.example.homework4_android5.di

import com.example.data.repositories.AnimeRepositoryImpl
import com.example.domain.repositories.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAnimeRepository(animeRepositoryImpl: AnimeRepositoryImpl): AnimeRepository
}