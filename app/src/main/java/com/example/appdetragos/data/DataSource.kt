package com.example.appdetragos.data

import com.example.appdetragos.vo.Resource

class DataSource {

    val generateTragosList = listOf(
        Drink("https://i.pinimg.com/originals/2c/a1/04/2ca104b0bfbf584d427ac65e5f309cbd.jpg","Margarita","Con azucar,Vodka y nueces"),
        Drink("https://images.clarin.com/2020/04/07/fernet-con-cola-el-trago___64p5_UOyq2_340x340__1.jpg","Fernet","Fernet con coca y 2 hielos"),
        Drink("https://i.ytimg.com/vi/q-58DYsOjDs/maxresdefault.jpg","Toro","Toro con pritty"),
        Drink("https://i1.tagstat.com/p1/p/uXPwegCCzMH--a9A8BI-toysnTYu99JunTiV43v-4MINofxJoK1kdzv2HqfSN_xQ.jpg","Gancia","Gancia con sprite")
    )
    fun getTragosList():Resource<List<Drink>>{
        return Resource.Success(generateTragosList)
    }

}