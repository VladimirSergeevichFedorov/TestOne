package com.bignerdranch.android.testone.network

import androidx.room.PrimaryKey
//import com.bignerdranch.android.testone.room.Test
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class UseData (
    val id: String,
    @Json(name = "img_src") val imgSrc: String
)