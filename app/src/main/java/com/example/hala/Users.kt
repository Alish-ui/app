package com.example.hala

data class Users(
    val name: String,
    val profilePicture: Int,  // Resource ID for image
    val isLive: Boolean,
    val interactionCount: Int,

)
