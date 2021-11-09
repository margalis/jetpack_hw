package com.example.jetpack.notes.ui.listnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.notes.data.entity.Note
import com.example.jetpack.notes.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesListViewModel(private val notesRepository: NoteRepository) : ViewModel() {
    private val _notesFlow = MutableStateFlow(emptyList<Note>())
    val notes: Flow<List<Note>> get() = _notesFlow

    init {
        //flow
        viewModelScope.launch(Dispatchers.IO) {
            _notesFlow.value = notesRepository.getNotes()
        }
    }
}