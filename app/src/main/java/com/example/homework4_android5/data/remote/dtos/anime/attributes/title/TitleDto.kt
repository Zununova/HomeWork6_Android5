package com.example.homework4_android5.data.remote.dtos.anime.attributes.title

import com.example.homework4_android5.domain.models.attributes.title.Title
import com.google.gson.annotations.SerializedName

data class TitleDto(
    @SerializedName("en")
    val title: String
)

fun TitleDto.toDomain() = Title(
    title
)
