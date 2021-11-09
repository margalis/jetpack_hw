package com.example.jetpack.notes.ui.addNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.notes.data.entity.Note
import com.example.jetpack.notes.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

//poxancum enq interfacey voch te impl-y
class AddNoteViewModel(private val notesRepository: NoteRepository) : ViewModel() {
    /*private val _progressLiveData: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val progressLiveData : LiveData<Int> get() =_progressLiveData*/

    //old usage
    /*
    init {
        //coroutine scope a
        /*viewModelScope.launch {
             for(i in 0..100){
                 delay(580)
                 _progressLiveData.value =i
             }
        } */

    }*/

    fun addNote(title: String, body: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.addNote(Note(title, body))
        }
    }
}