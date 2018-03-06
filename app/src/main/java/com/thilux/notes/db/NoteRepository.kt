package com.thilux.notes.db

import android.content.Context
import com.thilux.notes.NOTES_TABLE_NAME
import com.thilux.notes.database
import com.thilux.notes.dateFormatter
import com.thilux.notes.model.Note
import org.jetbrains.anko.db.*
import timber.log.Timber

/**
 * Created by tsantana on 03/03/18.
 */
class NoteRepository(val context: Context) {

    fun findAll() : ArrayList<Note> = context.database.use {
        val notes = ArrayList<Note>()

        select(NOTES_TABLE_NAME, "id", "title", "content", "creationDate")
                .parseList(object: MapRowParser<List<Note>>{
                    override fun parseRow(columns: Map<String, Any?>): List<Note> {
                        val id = columns.getValue("id")
                        val title = columns.getValue("title")
                        val content = columns.getValue("content")
                        val creationDate = columns.getValue("creationDate")

                        val note = Note(id.toString().toLong(), title.toString(), content.toString())
                        note.creationDate = dateFormatter.parse(creationDate.toString())

                        notes.add(note)

                        return notes
                    }
                })

        notes
    }

    fun create(note: Note) = context.database.use {
        insert(NOTES_TABLE_NAME,
                "title" to note.title,
                "content" to note.content,
                "creationDate" to dateFormatter.format(note.creationDate))
    }

    fun update(note: Note) = context.database.use {
        val updateResult = update(NOTES_TABLE_NAME,
                "title" to note.title,
                "content" to note.content)
                .whereArgs("id = {noteId}", "noteId" to note.id)
                //.whereSimple("id = ?", "230292")
                .exec()

        Timber.d("Update result code is $updateResult")
    }

    fun delete(note: Note) = context.database.use {
        delete(NOTES_TABLE_NAME, whereClause = "id = {noteId}", args = "noteId" to note.id)
    }
}