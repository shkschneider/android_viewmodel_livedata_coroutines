package me.shkschneider.viewmodellivedatacoroutines

import android.app.Application
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        MyDatabase.get(this).clearAllTables()
        DataManager.dummy(this)
    }

}