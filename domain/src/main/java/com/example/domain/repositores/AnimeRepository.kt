package com.example.domain.repositores

import com.example.domain.either.Either
import com.example.domain.models.models.Anime
import com.example.domain.models.models.DataModel
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun fetchAnime(): Flow<Either<String, List<Anime>>>

    fun fetchAnimeById(id: Int): Flow<Either<String, DataModel>>
}