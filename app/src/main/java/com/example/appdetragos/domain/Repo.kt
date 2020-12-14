package com.example.appdetragos.domain

import com.example.appdetragos.data.Drink
import com.example.appdetragos.vo.Resource

interface Repo {

   suspend fun getTragosList(tragoName:String):Resource<List<Drink>>
}