package com.example.homework4_android5.domain.models.attributes

import com.example.homework4_android5.domain.models.attributes.image.Image
import com.example.homework4_android5.domain.models.attributes.title.Title

data class Attributes(

    val createdAt: String,
    val updatedAt: String,
    val titles: Title,
    val detail: String,
    val posterImage: Image?,
    val averageRating: String,
//    val coverImage: Image
)
