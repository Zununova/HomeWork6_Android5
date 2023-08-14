package com.example.data.remote.dtos.anime.attributes.image

import com.example.domain.models.attributes.image.Image
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("original")
    val image: String
)

fun ImageDto.toDomain() = Image(
    image
)
