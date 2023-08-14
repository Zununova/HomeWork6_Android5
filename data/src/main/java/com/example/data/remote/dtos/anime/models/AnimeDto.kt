package com.example.data.remote.dtos.anime.models

import com.example.data.remote.dtos.anime.attributes.AttributesDto
import com.example.data.remote.dtos.anime.attributes.toDomain
import com.example.domain.models.models.Anime
import com.google.gson.annotations.SerializedName

data class AnimeDto(

    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributesDto: AttributesDto
)

fun AnimeDto.toDomain() = Anime(
    id,
    attributesDto.toDomain()
)