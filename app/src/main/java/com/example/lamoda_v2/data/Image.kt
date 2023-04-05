package com.example.lamoda_v2.data

import com.example.lamoda_v2.api.Urls
import kotlinx.serialization.SerialName

data class Image(
    val id : String,
    val alt_description : String,
    val urls : Urls
)
