package com.example.takenotes.common.data.di

import android.content.Context
import androidx.room.Room
import com.example.takenotes.common.data.cache.Cache
import com.example.takenotes.common.data.cache.NotesDatabase
import com.example.takenotes.common.data.cache.RoomCache
import com.example.takenotes.common.data.cache.daos.NotesDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindCache(cache: RoomCache): Cache

    companion object {

        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): NotesDatabase {
            return Room.databaseBuilder(
                context,
                NotesDatabase::class.java,
                "notes.db"
            )
                .build()
        }

        @Provides
        fun provideNotesDao(
            notesDatabase: NotesDatabase
        ): NotesDao = notesDatabase.notesDao()
    }
}