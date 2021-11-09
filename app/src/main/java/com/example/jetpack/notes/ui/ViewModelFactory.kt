package com.example.jetpack.notes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.notes.repository.NoteRepository
import com.example.jetpack.notes.ui.addNote.AddNoteViewModel

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        /*if (modelClass.isInstance(AddNoteViewModel::class)) {
            return AddNoteViewModel() as T
        }
        return modelClass.newInstance()*/
        TODO("was implemented in early version, now is not used")
    }
}