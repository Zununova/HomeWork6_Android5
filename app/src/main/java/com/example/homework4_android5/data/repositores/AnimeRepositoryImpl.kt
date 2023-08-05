package com.example.homework4_android5.data.repositores

import com.example.homework4_android5.data.remote.apiservice.AnimeApiService
import com.example.homework4_android5.data.remote.dtos.anime.models.toDomain
import com.example.homework4_android5.domain.Either
import com.example.homework4_android5.domain.models.models.Anime
import com.example.homework4_android5.domain.models.models.DataModel
import com.example.homework4_android5.domain.repositores.AnimeRepository
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