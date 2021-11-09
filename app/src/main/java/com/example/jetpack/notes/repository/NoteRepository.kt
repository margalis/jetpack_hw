package com.example.jetpack.notes.repository

import com.example.jetpack.notes.data.entity.Note

interface NoteRepository {
    suspend fun addNote(note: Note)
    suspend fun getNotes(): List<Note>
    suspend fun deleteNote(note: Note)
}