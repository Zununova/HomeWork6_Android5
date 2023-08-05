package com.example.homework4_android5.data.remote.dtos.anime.models

import com.example.homework4_android5.domain.models.models.DataModel
import com.google.gson.annotations.SerializedName

data class DataModelDto(

    @SerializedName("data")
    val animeAnimeDto: AnimeDto
)

fun DataModelDto.toDomain() = DataModel(
    animeAnimeDto.toDomain()
)

