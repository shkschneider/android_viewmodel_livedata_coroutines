package me.shkschneider.viewmodellivedatacoroutines

import android.app.Application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch {
            MyDatabase.get(applicationContext).clearAllTables()
            DataManager.dummy(applicationContext)
        }
    }

}