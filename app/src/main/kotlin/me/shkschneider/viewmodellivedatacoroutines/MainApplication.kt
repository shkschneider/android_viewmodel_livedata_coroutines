package me.shkschneider.viewmodellivedatacoroutines

import android.app.Application
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Coroutines.io {
            MyDatabase.get(applicationContext).clearAllTables()
            if (BuildConfig.DEBUG) {
                DataManager.dummy(applicationContext)
            }
        }
    }

}