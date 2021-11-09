package com.example.jetpack.notes.ui.listnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.jetpack.notes.R
import com.example.jetpack.notes.databinding.FragmentAddNoteBinding
import com.example.jetpack.notes.databinding.FragmentNotesListBinding
import com.example.jetpack.notes.ui.addNote.AddNoteViewModel
import com.example.jetpack.notes.ui.viewModelProvider.NotesViewModelFactory
import kotlinx.coroutines.launch

class NotesListFragment : Fragment() {
    private val viewModel: NotesListViewModel by viewModels(factoryProducer = {
        NotesViewModelFactory(requireContext()) //what is require context?
    })

    private var binding: FragmentNotesListBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNotesListBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localBinding = binding ?: return
        lifecycleScope.launch {
            TODO("repeatOnLifecycle() }viewModel.notes.collect{ }")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}