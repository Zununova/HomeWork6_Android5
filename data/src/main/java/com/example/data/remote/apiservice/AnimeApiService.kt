package com.example.data.remote.apiservice

import com.example.data.remote.dtos.anime.Response
import com.example.data.remote.dtos.anime.models.AnimeDto
import com.example.data.remote.dtos.anime.models.DataModelDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Response<AnimeDto>

    @GET("anime/{id}")
    suspend fun fetchAnimeById(
        @Path("id") id: Int
    ): DataModelDto
}