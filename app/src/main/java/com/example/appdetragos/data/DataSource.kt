package com.example.appdetragos.data

import com.example.appdetragos.vo.Resource
import com.example.appdetragos.vo.RetrofitClient
import retrofit2.Retrofit

class DataSource {

    suspend fun getTragosByName(tragosName: String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.WebService.getTragoByName(tragosName).drinkList)
    }


}