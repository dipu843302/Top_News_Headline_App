package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

   @GET("/v2/top-headlines")
   fun getUserDetails(@Query("country") country:String,
                      @Query("apiKey")  apiKey : String):Call<ResponseDTO>
}