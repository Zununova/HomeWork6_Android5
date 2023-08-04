package com.example.homework4_android5.domain.repositores

import com.example.homework4_android5.domain.Either
import com.example.homework4_android5.domain.models.models.Anime
import com.example.homework4_android5.domain.models.models.DataModel
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(): Flow<Either<String, List<Anime>>>

    fun fetchAnimeById(id: Int): Flow<Either<String, DataModel>>
}