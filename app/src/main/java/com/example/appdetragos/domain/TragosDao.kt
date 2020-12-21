package com.example.appdetragos.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.appdetragos.data.DrinkEntity


@Dao
interface TragosDao {

    @androidx.room.Query("SELECT * FROM tragosEntity")
    suspend fun getAllFavoriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserFavorite(tragos: DrinkEntity)

}
