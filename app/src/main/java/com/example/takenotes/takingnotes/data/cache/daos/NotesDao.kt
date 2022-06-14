package com.example.takenotes.takingnotes.data.cache.daos

import androidx.room.*
import com.example.takenotes.takingnotes.data.cache.model.CachedNote
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NotesDao {

    @Transaction
    @Query("SELECT * FROM notes")
    abstract fun getAllNotes(): Flow<List<CachedNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertNote(note: CachedNote)

    suspend fun insertNotes(notes: List<CachedNote>) {
        for (note in notes) {
            insertNote(note)
        }
    }
}