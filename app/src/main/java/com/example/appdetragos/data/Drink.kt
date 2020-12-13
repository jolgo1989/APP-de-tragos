package com.example.appdetragos.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    val imgen: String,
    val nombre: String,
    val descripcion: String ):Parcelable