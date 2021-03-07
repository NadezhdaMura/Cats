package com.example.catapp.data

import com.google.gson.annotations.SerializedName

data class Cat(
    val catData: CatData
)
data class CatData(
    @SerializedName("url")val url:String
)