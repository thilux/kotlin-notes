package com.thilux.notes.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.thilux.notes.EXTRA_FIELD_NOTE
import com.thilux.notes.R
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity(), View.OnClickListener {

    private var isUpdate = false
    private var existingNote: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        if (intent.hasExtra(EXTRA_FIELD_NOTE)){
            isUpdate = true
            val data: Bundle = intent.extras
            existingNote = data.getParcelable<Note>(EXTRA_FIELD_NOTE)
        }

        buttonNoteAddUpdate.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if (view.equals(buttonNoteAddUpdate)){
            if (isUpdate){
                updateNote()
            }else{
                createNote()
            }

        }else{ // view.equals(buttonCancel)
            finish()
        }

    }

    private fun createNote(){
        val newNote = Note(0, editNoteTitle.text.toString(), editNoteContent.text.toString())
        NoteRepository(this).create(newNote)
    }

    private fun updateNote(){
        existingNote.let {
            NoteRepository(this).update(it!!)
        }
    }
}
