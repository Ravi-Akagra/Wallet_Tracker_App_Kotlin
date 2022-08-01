package com.Akagra.wallettracker.ui.fragmentPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.Akagra.wallettracker.data.CurrencyNotes
import com.Akagra.wallettracker.databinding.FragmentNotesPageBinding
import com.Akagra.wallettracker.ui.CurrencyViewModel
import com.Akagra.wallettracker.ui.INoteRVAdapter
import com.Akagra.wallettracker.ui.NotePageRVAdapter


class NotesPage : Fragment(), INoteRVAdapter {
    private lateinit var noteBinding: FragmentNotesPageBinding
    private lateinit var viewModel : CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteBinding = FragmentNotesPageBinding.inflate(layoutInflater)
        viewModel =  ViewModelProvider(this).get(CurrencyViewModel::class.java)

        val recyclerView = noteBinding.notesRecyclerView
        val adapter = this.context?.let { NotePageRVAdapter(it,this) }
        recyclerView.adapter = adapter

        viewModel.allNotes.observe(this) {
            it?.let {
                println("$it steve")
                adapter?.updateList(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return noteBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesPage()
    }

    override fun onAddButtonClicked(note: CurrencyNotes) {
        viewModel.incrementNotes(note.value,note.count)
    }

    override fun onSubtractButtonClicked(note: CurrencyNotes) {
        viewModel.decrementNotes(note.value,note.count)
    }
}