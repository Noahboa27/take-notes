package com.example.takenotes.common.data.cache

import com.example.takenotes.common.data.cache.daos.NotesDao
import com.example.takenotes.common.data.cache.model.CachedNote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomCache @Inject constructor(
    private val notesDao: NotesDao
) : Cache {

    override fun getNotes(): Flow<List<CachedNote>> {
        return notesDao.getAllNotes()
    }

    override suspend fun storeNotes(notes: List<CachedNote>) {
        notesDao.insertNotes(notes)
    }
}