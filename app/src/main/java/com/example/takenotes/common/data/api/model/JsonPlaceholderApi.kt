package com.example.takenotes.common.data.api.model

import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET(ApiConstants.TODO_ENDPOINT)
    suspend fun getNotes(): List<ApiNote>?
}