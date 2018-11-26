package me.shkschneider.viewmodellivedatacoroutines

import androidx.annotation.WorkerThread
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

object DataManager {

    @WorkerThread
    fun dummy() {
        val db = MyDatabase.get()
        db.users().insert(User(login = "user.name"))
        db.projects().insert(Project(name = "project.name"))
        db.notifications().insert(Notification(msg = "created"))
    }

    @WorkerThread
    fun getUsers(): List<User> {
        return MyDatabase.get().users().getAll()
    }

    @WorkerThread
    fun getProjects(): List<Project> {
        return MyDatabase.get().projects().getAll()
    }

    @WorkerThread
    fun getNotifications(): List<Notification> {
        return MyDatabase.get().notifications().getAll()
    }

}