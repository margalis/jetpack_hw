package com.example.jetpack.notes.data.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpack.notes.data.dao.NotesDao

@Database(
    entities = [Note::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "notes_db"
        )
            .fallbackToDestructiveMigration() //henc versiony poxvec taza local baza a steghvumhiny jnjum a
            .build()

    }

    abstract fun getNotesDao(): NotesDao
}