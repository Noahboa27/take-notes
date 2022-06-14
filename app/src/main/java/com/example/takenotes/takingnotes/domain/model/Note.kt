package com.example.takenotes.takingnotes.domain.model

data class Note(
    val id: Int,
    val userId: Int,
    val message: String,
    val isCompleted: Boolean
)
