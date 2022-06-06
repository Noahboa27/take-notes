package com.example.takenotes.common.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.takenotes.common.data.cache.daos.NotesDao
import com.example.takenotes.common.data.cache.model.CachedNote

@Database(
    entities = [
        CachedNote::class
    ],
    version = 1
)

abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}