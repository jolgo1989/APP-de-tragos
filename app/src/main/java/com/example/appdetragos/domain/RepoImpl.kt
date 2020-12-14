package com.example.appdetragos.domain

import com.example.appdetragos.data.DataSource
import com.example.appdetragos.data.Drink
import com.example.appdetragos.vo.Resource

class RepoImpl(private val dataSource:DataSource):Repo {

  override suspend fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragosByName(tragoName)
    }
}
