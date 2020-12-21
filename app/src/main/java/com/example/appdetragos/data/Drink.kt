package com.example.appdetragos.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    @SerializedName("IdDrink")
    val tragosID: String="",
    @SerializedName("strDrinkThumb")
    val imgen: String,
    @SerializedName("strDrink")
    val nombre: String,
    @SerializedName("strInstructions")
    val descripcion: String ):Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinkList:List<Drink> = listOf()
)

@Entity(tableName =  "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val tragoId: String,
    @ColumnInfo(name = "strDrinkThumb")
    val imgen: String,
    @ColumnInfo(name = "strDrink")
    val nombre: String,
    @ColumnInfo(name = "strInstructions")
    val descripcion: String
)