package com.example.homework4_android5.data.remote.dtos.anime.attributes.image

import com.example.homework4_android5.domain.models.attributes.image.Image
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("original")
    val image: String
)

fun ImageDto.toDomain() = Image(
    image
)
