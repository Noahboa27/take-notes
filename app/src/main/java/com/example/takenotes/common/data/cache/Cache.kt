package com.example.takenotes.common.data.cache

import com.example.takenotes.common.data.cache.model.CachedNote
import kotlinx.coroutines.flow.Flow

interface Cache {
    fun getNotes(): Flow<List<CachedNote>>
    suspend fun storeNotes(notes: List<CachedNote>)
}