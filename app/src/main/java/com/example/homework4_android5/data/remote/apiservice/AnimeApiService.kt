package com.example.homework4_android5.data.remote.apiservice

import com.example.homework4_android5.data.dtos.anime.Response
import com.example.homework4_android5.data.dtos.anime.models.AnimeDto
import com.example.homework4_android5.data.dtos.anime.models.DataModelDto
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