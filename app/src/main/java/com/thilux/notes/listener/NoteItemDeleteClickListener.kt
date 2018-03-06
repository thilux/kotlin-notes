package com.thilux.notes.listener

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import com.thilux.notes.R
import com.thilux.notes.activity.MainActivity
import com.thilux.notes.db.NoteRepository
import com.thilux.notes.model.Note
import timber.log.Timber

/**
 * Created by tsantana on 05/03/18.
 */
class NoteItemDeleteClickListener(val note: Note, val activity: Activity) : View.OnClickListener {

    override fun onClick(view: View?) {

        val alertDialog = AlertDialog.Builder(activity)
        alertDialog.setTitle(R.string.dialog_delete_note_title)
        alertDialog.setMessage(R.string.dialog_delete_note_confirmation)
        alertDialog.setPositiveButton(android.R.string.yes, object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, whichButton: Int) {
                Timber.d("Request to delete note ${note.id} - ${note.title}")
                NoteRepository(activity).delete(note)
                Toast.makeText(activity, R.string.dialog_delete_note_deleted, Toast.LENGTH_SHORT).show()
                activity.recreate()
            }
        })

        alertDialog.setNegativeButton(android.R.string.no, null)

        alertDialog.show()

    }
}