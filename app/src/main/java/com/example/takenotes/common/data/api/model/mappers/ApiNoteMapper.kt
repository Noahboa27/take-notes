package com.example.takenotes.common.data.api.model.mappers

import com.example.takenotes.common.data.api.model.ApiNote
import com.example.takenotes.common.domain.model.Note
import javax.inject.Inject

class ApiNoteMapper @Inject constructor(): ApiMapper<ApiNote?, Note> {

    override fun mapToDomain(apiEntity: ApiNote?): Note {
        return Note(
            userId = apiEntity?.userId ?: Int.MAX_VALUE,
            id = apiEntity?.id ?: Int.MAX_VALUE,
            message = apiEntity?.message.orEmpty(),
            isCompleted = apiEntity?.isCompleted ?: false
        )
    }
}