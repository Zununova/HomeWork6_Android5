package com.example.homework4_android5.data.remote.dtos.anime

import com.google.gson.annotations.SerializedName

data class Links(

    @SerializedName("first")
    val first: String,
    @SerializedName("next")
    val next: String?,
    @SerializedName("prev")
    val prev: String?,
    @SerializedName("last")
    val last: String,
)
