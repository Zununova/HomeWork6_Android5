package com.example.data.remote.dtos.anime.models

import com.example.domain.models.models.DataModel
import com.google.gson.annotations.SerializedName

data class DataModelDto(

    @SerializedName("data")
    val animeAnimeDto: AnimeDto
)

fun DataModelDto.toDomain() = DataModel(
    animeAnimeDto.toDomain()
)

