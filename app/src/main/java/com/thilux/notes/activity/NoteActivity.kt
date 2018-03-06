package com.thilux.notes.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.thilux.notes.EXTRA_FIELD_NOTE
import com.thilux.notes.R
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note
import kotlinx.android.synthetic.main.activity_note.*
import timber.log.Timber

class NoteActivity : AppCompatActivity(), View.OnClickListener {

    private var isUpdate = false
    private var existingNote: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        if (intent.hasExtra(EXTRA_FIELD_NOTE)){
            textNoteLayoutTitle.text = getText(R.string.activity_note_activity_title_update)
            buttonNoteAddUpdate.text = getText(R.string.activity_note_button_update)
            isUpdate = true
            val data: Bundle = intent.extras
            existingNote = data.getParcelable<Note>(EXTRA_FIELD_NOTE)
            editNoteTitle.setText(existingNote?.title, TextView.BufferType.EDITABLE)
            editNoteContent.setText(existingNote?.content, TextView.BufferType.EDITABLE)
        }

        buttonNoteAddUpdate.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if (view == buttonNoteAddUpdate){
            if (isUpdate){
                updateNote()
            }else{
                createNote()
            }

        }

        finish()

    }

    private fun createNote(){
        val newNote = Note(0, editNoteTitle.text.toString(), editNoteContent.text.toString())
        NoteRepository(this).create(newNote)
    }

    private fun updateNote(){
        val updatedNote = Note(existingNote!!.id, editNoteTitle.text.toString(), editNoteContent.text.toString())
        updatedNote.creationDate = existingNote!!.creationDate
        Timber.d("Requesting to update note ${existingNote!!.id} - ${existingNote!!.title}")
        NoteRepository(this).update(updatedNote)
    }
}
