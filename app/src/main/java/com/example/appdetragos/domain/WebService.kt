package com.example.appdetragos.domain

import com.example.appdetragos.data.Drink
import com.example.appdetragos.data.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?s=")
    suspend fun getTragoByName(@Query("tragoName") tragosName: String):DrinkList

}