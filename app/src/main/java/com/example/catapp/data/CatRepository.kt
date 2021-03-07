package com.example.catapp.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatRepository: CoroutineScope {
    override val coroutineContext = Dispatchers.IO
    private val catApi: CatApi = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CatApi::class.java)

    fun getData() = async{
        catApi.getData()
            .execute()
            .body()
    }
}