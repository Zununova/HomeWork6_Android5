package com.example.data.repositores

import com.example.data.remote.apiservice.AnimeApiService
import com.example.data.remote.dtos.anime.models.toDomain
import com.example.domain.either.Either
import com.example.domain.models.models.Anime
import com.example.domain.models.models.DataModel
import com.example.domain.repositores.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val service: AnimeApiService) :
    AnimeRepository {

    override fun fetchAnime() = flow<Either<String, List<Anime>>> {
        emit(Either.Right(service.fetchAnime().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Very big error"))
    }

    override fun fetchAnimeById(id: Int) = flow<Either<String, DataModel>> {
        emit(Either.Right(service.fetchAnimeById(id).toDomain()))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Very big error"))
    }
}