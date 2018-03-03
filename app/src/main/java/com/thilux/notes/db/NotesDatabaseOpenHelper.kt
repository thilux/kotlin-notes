package com.thilux.notes.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.thilux.notes.NOTES_DB_NAME
import com.thilux.notes.NOTES_TABLE_NAME
import org.jetbrains.anko.db.*

/**
 * Created by tsantana on 03/03/18.
 */
class NotesDatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, NOTES_DB_NAME, null, 1) {

    companion object {
        private var instance: NotesDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): NotesDatabaseOpenHelper {
            if (instance == null){
                instance = NotesDatabaseOpenHelper(context.applicationContext)
            }

            return instance!!
        }
    }

    override fun onCreate(database: SQLiteDatabase) {

        database.createTable(NOTES_TABLE_NAME, true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "title" to TEXT + NOT_NULL,
                "content" to TEXT,
                "creationDate" to TEXT)

    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        database.dropTable(NOTES_TABLE_NAME, ifExists = true)

    }
}