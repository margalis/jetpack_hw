package com.example.jetpack.notes.repository

import com.example.jetpack.notes.data.dao.NotesDao
import com.example.jetpack.notes.data.entity.Note

internal class NoteRepositoryImpl(private val notesDao: NotesDao) : NoteRepository {
    override suspend fun addNote(note: Note) = notesDao.insert(note)

    override suspend fun getNotes(): List<Note> = notesDao.getNotes()

    override suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)
}