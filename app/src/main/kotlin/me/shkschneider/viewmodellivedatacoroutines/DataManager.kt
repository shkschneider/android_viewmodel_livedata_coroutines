package me.shkschneider.viewmodellivedatacoroutines

import android.content.Context
import androidx.annotation.WorkerThread
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

object DataManager {

    @WorkerThread
    fun dummy(context: Context) {
        val db = MyDatabase.get(context)
        db.users().insert(User(login = "user.name"))
        db.projects().insert(Project(name = "project.name"))
        db.notifications().insert(Notification(msg = "created"))
    }

}