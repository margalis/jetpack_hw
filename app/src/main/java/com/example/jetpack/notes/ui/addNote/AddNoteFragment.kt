package com.example.jetpack.notes.ui.addNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jetpack.notes.databinding.FragmentAddNoteBinding
import com.example.jetpack.notes.ui.viewModelProvider.NotesViewModelFactory

class AddNoteFragment : Fragment() {

    /* //OLd view model usage
       *//*private lateinit var viewModel: AddNoteViewModel *//* // ete sovorakan objecti nman steghtsenq`
    // =new ViewModel()
    //or  we could just do
    private val viewModel: AddNoteViewModel by viewModels() // delegate-ov nuyn bann a generacvum
    // ^kara stegh argument poxancvi ViewModelProducer
    // horizontali ancnelis hin ardyunqy chi pahi ,dra hamar provider/factory
    // enq  ogtagortsum
*/
    private val viewModel: AddNoteViewModel by viewModels(factoryProducer = {
        NotesViewModelFactory(requireContext()) //what is require context?
    })

    //VIEW BINDING
    private var binding: FragmentAddNoteBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* binding= FragmentAddNoteBinding.inflate(inflater,container ,false)
         return binding?.root*/
        //or
        return FragmentAddNoteBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* viewModel =
             ViewModelProvider(viewModelStore, ViewModelFactory())[AddNoteViewModel::class.java]*/

        //VIEW BINDING
        val localBinding = binding ?: return
        //sranq arden cherez localBinding  khaskana
        /* val etTitle: EditText = view.findViewById(R.id.etTitle)
         val etBody: EditText = view.findViewById(R.id.etBody)
         val btnAdd: Button = view.findViewById(R.id.btnAdd)
         val progressIndicator: CircularProgressIndicator = view.findViewById(R.id.progress)*/

        //progress cycle-i code-y
        /*viewModel.progressLiveData.observe(viewLifecycleOwner) { progress ->
            localBinding.progressIndicator.progress = progress
        }*/


        localBinding.btnAdd.setOnClickListener {
            viewModel.addNote(
                title = localBinding.etTitle.text.toString(),
                body = localBinding.etBody.text.toString()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
