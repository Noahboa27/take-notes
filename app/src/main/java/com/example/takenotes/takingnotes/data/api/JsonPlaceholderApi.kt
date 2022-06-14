package com.example.takenotes.takingnotes.data.api

import com.example.takenotes.common.data.api.model.ApiConstants
import com.example.takenotes.takingnotes.data.api.model.ApiNote
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET(ApiConstants.TODO_ENDPOINT)
    suspend fun getNotes(): List<ApiNote>?
}