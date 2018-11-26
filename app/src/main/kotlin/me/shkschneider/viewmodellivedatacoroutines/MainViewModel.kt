package me.shkschneider.viewmodellivedatacoroutines

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

// TODO avoid passing the Context here
class MainViewModel : ViewModel() {

    private lateinit var users: MutableLiveData<List<User>>

    fun getUsers(context: Context): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            users.postValue(MyDatabase.get(context).users().getAll())
        }
        return users
    }

    private lateinit var projects: MutableLiveData<List<Project>>

    fun getProjects(context: Context): LiveData<List<Project>> {
        if (!::projects.isInitialized) {
            projects = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            projects.postValue(MyDatabase.get(context).projects().getAll())
        }
        return projects
    }

    private lateinit var notifications: MutableLiveData<List<Notification>>

    fun getNotifications(context: Context): LiveData<List<Notification>> {
        if (!::notifications.isInitialized) {
            notifications = MutableLiveData()
            // TODO loading of the data (hopefully using coroutines)
            notifications.postValue(MyDatabase.get(context).notifications().getAll())
        }
        return notifications
    }

}