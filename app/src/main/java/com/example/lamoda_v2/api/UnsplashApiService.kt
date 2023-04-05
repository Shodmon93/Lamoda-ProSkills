package com.ru.gridrecyclerview.Api

import com.example.lamoda_v2.data.Brand
import com.example.lamoda_v2.data.Image
import com.example.lamoda_v2.data.Season
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://api.unsplash.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UnsplashApiService {
    @Headers("Authorization: Client-ID kurunzHx57LPTLDpbn9anGrnyWeIUc6WiSsW-4f6LmI")
    @GET("photos")
    suspend fun getBrands() : List<Brand>

    @Headers("Authorization: Client-ID kurunzHx57LPTLDpbn9anGrnyWeIUc6WiSsW-4f6LmI")
    @GET("photos")
    suspend fun getSeason() : List<Season>

    @Headers("Authorization: Client-ID kurunzHx57LPTLDpbn9anGrnyWeIUc6WiSsW-4f6LmI")
    @GET("photos")
    suspend fun getImage() : List<Image>

}

object UnsplashApi {
    val retrofitService : UnsplashApiService by lazy {
        retrofit.create(UnsplashApiService::class.java)
    }
}