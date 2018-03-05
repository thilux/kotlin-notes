package com.thilux.notes.listener

import android.content.Context
import android.view.View
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note

/**
 * Created by tsantana on 05/03/18.
 */
class NoteItemUpdateClickListener(val note: Note, val context: Context) : View.OnClickListener {

    override fun onClick(view: View?) {

        NoteRepository(context).update(note)

    }
}