package com.example.homework4_android5.data.dtos.anime

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<T>
)