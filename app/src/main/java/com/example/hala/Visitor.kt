package com.example.hala

data class Visitor(
    val name: String,
    val id: String,
    val profileImage: Int,
    val flag: Int,
    val timestamp: String,
    val lastSeen: String,  // Extra field
    val isOnline: Boolean, // Extra field
    val isTopVisitor: Boolean, // Extra field
    val isGiftSender: Boolean // Extra field
)
