package com.example.data.remote.dtos.anime.attributes

import com.example.data.remote.dtos.anime.attributes.image.ImageDto
import com.example.data.remote.dtos.anime.attributes.image.toDomain
import com.example.data.remote.dtos.anime.attributes.title.TitleDto
import com.example.data.remote.dtos.anime.attributes.title.toDomain
import com.example.domain.models.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class AttributesDto(

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("updatedAt")
    val updatedAt: String,

    @SerializedName("titles")
    val titlesDto: TitleDto,

    @SerializedName("synopsis")
    val detail: String,

    @SerializedName("posterImage")
    val posterImageDto: ImageDto,

    @SerializedName("averageRating")
    val averageRating: String,

    @SerializedName("coverImage")
    val coverImageDto: ImageDto

)

fun AttributesDto.toDomain() = Attributes(
    createdAt,
    updatedAt,
    titlesDto.toDomain(),
    detail,
    posterImageDto.toDomain(),
    averageRating
)
