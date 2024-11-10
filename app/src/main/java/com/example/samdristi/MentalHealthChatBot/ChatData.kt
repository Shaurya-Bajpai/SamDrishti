package com.example.samdristi.MentalHealthChatBot

data class ChatData (
    val message : String ,
    val role : String
)

enum class ChatRoleEnum(val role : String)
{
    USER(role = "user"),
    MODEL(role = "model")
}