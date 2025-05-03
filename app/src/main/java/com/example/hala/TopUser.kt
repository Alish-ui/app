package com.example.hala

// Data model class for TopUser
data class TopUser(
    val name: String,
    val emoji: String,
    val imageResId: Int,
    val isFollowing: Boolean,
    val rank: Int,
    val extraInfo: String
)

