package com.example.samdristi.CivicIssuesChatBot

data class CivicChatData (
    val message : String ,
    val role : String
)

enum class ChatRoleEnum(val role : String)
{
    USER(role = "user"),
    MODEL(role = "model")
}