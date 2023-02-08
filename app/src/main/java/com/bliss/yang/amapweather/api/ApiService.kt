package com.bliss.yang.amapweather.api

import androidx.lifecycle.MutableLiveData
import com.bliss.yang.amapweather.data.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("simpleWeather/query")
    suspend fun getWeatherResult(
        @Query("city") city: String,
        @Query("key") key: String = "d3619567ef42fbe108d9392a33817b7c"
    ) : Response<Weather>

}