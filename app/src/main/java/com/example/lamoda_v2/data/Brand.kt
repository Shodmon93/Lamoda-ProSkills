package com.example.lamoda_v2.data
import com.example.lamoda_v2.api.Urls
import kotlinx.serialization.SerialName

data class Brand(
    val id : String = "",
    val alt_description : String = "",
    @SerialName("urls")
    val urls: Urls? = null
)
