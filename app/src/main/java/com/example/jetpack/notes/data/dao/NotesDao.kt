package com.example.jetpack.notes.data.dao

import androidx.room.*
import com.example.jetpack.notes.data.entity.Note

@Dao  // kaminterface petq e lini, kam abstract class, vortev inqy zut parent a?
interface NotesDao {

    @Insert //(onConflict=OnConflictStrategy.ABORT)
    suspend fun insert(vararg note: Note)
  //async
    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<Note>

    @Delete
    suspend fun deleteNote(note: Note)
}