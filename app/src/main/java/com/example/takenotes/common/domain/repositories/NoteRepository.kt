package com.example.takenotes.common.domain.repositories

import com.example.takenotes.common.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun requestForNotes(): List<Note>
    suspend fun storeNotes(notes: List<Note>)
}