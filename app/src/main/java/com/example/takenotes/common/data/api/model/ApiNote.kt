package com.example.takenotes.common.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiNote(
    @field:Json(name = "userId") val userId: Int?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "title") val message: String?,
    @field:Json(name = "completed") val isCompleted: Boolean?,
)
