package com.thilux.notes.listener

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import com.thilux.notes.R
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note

/**
 * Created by tsantana on 05/03/18.
 */
class NoteItemDeleteClickListener(val note: Note, val context: Context) : View.OnClickListener {

    override fun onClick(view: View?) {

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(R.string.dialog_delete_note_title)
        alertDialog.setMessage(R.string.dialog_delete_note_confirmation)
        alertDialog.setPositiveButton(android.R.string.yes, object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, whichButton: Int) {
                NoteRepository(context).delete(note)
                Toast.makeText(context, R.string.dialog_delete_note_deleted, Toast.LENGTH_SHORT).show()
            }
        })

        alertDialog.setNegativeButton(android.R.string.no, null)

        alertDialog.show()

    }
}