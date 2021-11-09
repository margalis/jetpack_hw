package com.example.jetpack.notes.ui.viewModelProvider

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.notes.data.entity.AppDataBase
import com.example.jetpack.notes.repository.NoteRepositoryImpl
import com.example.jetpack.notes.ui.addNote.AddNoteViewModel
import com.example.jetpack.notes.ui.listnotes.NotesListViewModel

class NotesViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //pre dependency injection version
        val noteRepoImpl = NoteRepositoryImpl(
            AppDataBase.buildDatabase(context.applicationContext).getNotesDao()
        )

        return when (modelClass) {
            AddNoteViewModel::class.java -> AddNoteViewModel(noteRepoImpl)
            NotesListViewModel::class.java ->  NotesListViewModel(noteRepoImpl)
            else -> modelClass.newInstance()
        } as T
    }
}