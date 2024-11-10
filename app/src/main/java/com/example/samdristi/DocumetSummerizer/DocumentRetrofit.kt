package com.example.samdristi.DocumetSummerizer


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class LegalTextRequest(val legal_text: String)
data class SimplifiedTextResponse(val simplified_text: String)

interface ApiService {
    @POST("/simplify")
    suspend fun simplifyLegalText(@Body request: LegalTextRequest): SimplifiedTextResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://ead6bccd-9cb4-4120-b3dc-fe17c7b8b147-00-12i95cbw2nrhf.sisko.replit.dev/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}