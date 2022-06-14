package com.example.takenotes.takingnotes.data.repositories

import com.example.takenotes.takingnotes.data.api.JsonPlaceholderApi
import com.example.takenotes.takingnotes.data.api.model.mappers.ApiNoteMapper
import com.example.takenotes.common.data.cache.Cache
import com.example.takenotes.takingnotes.data.cache.model.CachedNote
import com.example.takenotes.common.domain.model.Exceptions
import com.example.takenotes.takingnotes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import javax.inject.Inject

class TakeNotesRepository @Inject constructor(
    private val api: JsonPlaceholderApi,
    private val cache: Cache,
    private val noteMapper: ApiNoteMapper
): NotesRepository {

    override fun getNotes(): Flow<List<Note>> {
        return cache.getNotes()
            .distinctUntilChanged()
            .map { notesList ->
                notesList.map { it.toDomain(it) }
            }
    }

    override suspend fun requestForNotes(): List<Note> {
        return try {
            val apiNotes = api.getNotes()
            apiNotes?.map { noteMapper.mapToDomain(it) }.orEmpty()
        }  catch (exception: HttpException) {
            throw Exceptions.NetworkException(exception.message ?: "Code ${exception.code()}")
        }
    }

    override suspend fun storeNotes(notes: List<Note>) {
        cache.storeNotes(notes.map { CachedNote.fromDomain(it) })
    }
}