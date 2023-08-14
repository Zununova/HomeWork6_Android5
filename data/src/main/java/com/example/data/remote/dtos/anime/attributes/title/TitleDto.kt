package com.example.data.remote.dtos.anime.attributes.title

import com.example.domain.models.attributes.title.Title
import com.google.gson.annotations.SerializedName

data class TitleDto(
    @SerializedName("en")
    val title: String
)

fun TitleDto.toDomain() = Title(
    title
)
