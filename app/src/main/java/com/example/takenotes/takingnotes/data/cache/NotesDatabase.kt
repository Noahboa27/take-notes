package com.example.takenotes.takingnotes.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.takenotes.takingnotes.data.cache.daos.NotesDao
import com.example.takenotes.takingnotes.data.cache.model.CachedNote

@Database(
    entities = [
        CachedNote::class
    ],
    version = 1
)

abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}