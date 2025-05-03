package com.example.hala

data class User(
    val name: String,
    val status: String,
    val imageRes: Int,
    val isPinned: Boolean,
    val rank: Int,
    val emoji: String // Removed the trailing comma here
)
