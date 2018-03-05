package com.thilux.notes.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.thilux.notes.R
import com.thilux.notes.listener.NoteItemDeleteClickListener
import com.thilux.notes.listener.NoteItemUpdateClickListener
import com.thilux.notes.model.Note

/**
 * Created by tsantana on 03/03/18.
 */
class NotesListAdapter(private var activity: Activity, private var values: ArrayList<Note>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var textNoteTitle: TextView? = null
        var textNoteContent: TextView? = null
        var buttonUpdate: Button? = null
        var buttonDelete: Button? = null

        init {
            this.textNoteTitle = row?.findViewById<TextView>(R.id.textNoteTitle)
            this.textNoteContent = row?.findViewById<TextView>(R.id.textNoteContent)
            this.buttonUpdate = row?.findViewById<Button>(R.id.buttonUpdate)
            this.buttonDelete = row?.findViewById<Button>(R.id.buttonDelete)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null){
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.notes_list_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val note = values[position]
        viewHolder.textNoteTitle?.text = note.title
        viewHolder.textNoteContent?.text = note.content
        viewHolder.buttonUpdate?.setOnClickListener(NoteItemUpdateClickListener(note, activity))
        viewHolder.buttonDelete?.setOnClickListener(NoteItemDeleteClickListener(note, activity))

        return view as View

    }

    override fun getItem(position: Int): Note {
        return values[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getCount(): Int {
        return values.size
    }
}