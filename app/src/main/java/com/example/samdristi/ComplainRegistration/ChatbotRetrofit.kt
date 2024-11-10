package com.example.samdristi.ComplainRegistration


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://7a91c0b4-6313-4819-98d4-973d8072b314-00-1yblch4r8qz93.picard.replit.dev/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

//https://ead6bccd-9cb4-4120-b3dc-fe17c7b8b147-00-12i95cbw2nrhf.sisko.replit.dev/