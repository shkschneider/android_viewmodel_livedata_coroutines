package me.shkschneider.viewmodellivedatacoroutines

import android.app.Application
import android.content.Context
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase

@Suppress("unused")
class MainApplication : Application() {

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()

        Coroutines.io {
            MyDatabase.get().clearAllTables()
            if (BuildConfig.DEBUG) {
                DataManager.dummy()
            }
        }
    }

    companion object {

        private var INSTANCE: MainApplication? = null

        fun applicationContext() : Context {
            return INSTANCE!!.applicationContext
        }

    }

}