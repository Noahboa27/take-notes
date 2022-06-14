package com.example.takenotes.takingnotes.data.api.model.mappers

import com.example.takenotes.common.data.api.model.mappers.ApiMapper
import com.example.takenotes.takingnotes.data.api.model.ApiNote
import com.example.takenotes.takingnotes.domain.model.Note
import javax.inject.Inject

class ApiNoteMapper @Inject constructor(): ApiMapper<ApiNote?, Note> {

    override fun mapToDomain(apiEntity: ApiNote?): Note {
        return Note(
            userId = apiEntity?.userId ?: 0,
            id = apiEntity?.id ?: 0,
            message = apiEntity?.message.orEmpty(),
            isCompleted = apiEntity?.isCompleted ?: false
        )
    }
}