package com.example.appdetragos.domain

import com.example.appdetragos.data.Drink
import com.example.appdetragos.vo.Resource

interface Repo {

    fun getTragosList():Resource<List<Drink>>
}