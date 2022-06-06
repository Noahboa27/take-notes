package com.example.takenotes.common.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.takenotes.common.domain.model.Note

@Entity(
    tableName = "notes"
)

data class CachedNote (
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val message: String,
    val isCompleted: Boolean
) {
    fun toDomain(cachedNote: CachedNote): Note {
        return Note(
            cachedNote.id,
            cachedNote.userId,
            cachedNote.message,
            cachedNote.isCompleted
        )
    }

    companion object {
        fun fromDomain(note: Note): CachedNote {
            return CachedNote(
                note.id,
                note.userId,
                note.message,
                note.isCompleted
            )
        }
    }
}