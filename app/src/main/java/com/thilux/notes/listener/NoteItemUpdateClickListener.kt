package com.thilux.notes.listener

import android.content.Context
import android.content.Intent
import android.view.View
import com.thilux.notes.EXTRA_FIELD_NOTE
import com.thilux.notes.activity.NoteActivity
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note

/**
 * Created by tsantana on 05/03/18.
 */
class NoteItemUpdateClickListener(val note: Note, val context: Context) : View.OnClickListener {

    override fun onClick(view: View?) {

        val intent = Intent(context, NoteActivity::class.java)
        intent.putExtra(EXTRA_FIELD_NOTE, note)
        context.startActivity(intent)

    }
}