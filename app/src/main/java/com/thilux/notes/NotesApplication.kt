package com.thilux.notes

import android.app.Application
import timber.log.Timber

/**
 * Created by tsantana on 05/03/18.
 */
class NotesApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}