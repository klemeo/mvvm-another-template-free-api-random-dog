package ru.android.anothermvvmrandomdog.data

import retrofit2.Call
import retrofit2.http.GET

interface DogApi {

    @GET("breeds/image/random")
    fun getDog(): Call<DogDto>

}