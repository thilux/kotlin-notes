package com.thilux.notes.model

import java.util.*

/**
 * Created by tsantana on 03/03/18.
 */
data class Note(val id: Long, val title: String, val content: String){
    var creationDate: Date = Date()
}