package com.example.takenotes.takingnotes.data.repositories

import com.example.takenotes.takingnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun requestForNotes(): List<Note>
    suspend fun storeNotes(notes: List<Note>)
}