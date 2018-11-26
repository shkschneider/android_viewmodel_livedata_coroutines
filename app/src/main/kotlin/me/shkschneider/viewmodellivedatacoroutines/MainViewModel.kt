package me.shkschneider.viewmodellivedatacoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

class MainViewModel : ViewModel() {

    private lateinit var users: MutableLiveData<List<User>>

    fun getUsers(): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            users.postValue(arrayListOf(
                User(login = "user.name1"),
                User(login = "user.name2")
            ))
        }
        return users
    }

    private lateinit var projects: MutableLiveData<List<Project>>

    fun getProjects(): LiveData<List<Project>> {
        if (!::projects.isInitialized) {
            projects = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            projects.postValue(arrayListOf(
                Project(name = "project.name1"),
                Project(name = "project.name2")
            ))
        }
        return projects
    }

    private lateinit var notifications: MutableLiveData<List<Notification>>

    fun getNotifications(): LiveData<List<Notification>> {
        if (!::notifications.isInitialized) {
            notifications = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            notifications.postValue(arrayListOf(
                Notification(msg = "First notification"),
                Notification(msg = "Second notification")
            ))
        }
        return notifications
    }

}