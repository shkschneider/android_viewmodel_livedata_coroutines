package me.shkschneider.viewmodellivedatacoroutines

import android.content.Context
import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import me.shkschneider.viewmodellivedatacoroutines.data.MyDatabase
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

// TODO avoid passing the Context here
class MainViewModel : ViewModel() {

    private lateinit var users: MutableLiveData<List<User>>

    @UiThread
    fun getUsers(context: Context): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
            GlobalScope.launch(Dispatchers.Main) {
                val usersFromDb: List<User> = async(Dispatchers.IO) {
                    return@async MyDatabase.get(context).users().getAll()
                }.await()
                users.postValue(usersFromDb)
            }
        }
        return users
    }

    private lateinit var projects: MutableLiveData<List<Project>>

    @UiThread
    fun getProjects(context: Context): LiveData<List<Project>> {
        if (!::projects.isInitialized) {
            projects = MutableLiveData()
            GlobalScope.launch(Dispatchers.Main) {
                val projectsFromDb: List<Project> = async(Dispatchers.IO) {
                    return@async MyDatabase.get(context).projects().getAll()
                }.await()
                projects.postValue(projectsFromDb)
            }
        }
        return projects
    }

    private lateinit var notifications: MutableLiveData<List<Notification>>

    @UiThread
    fun getNotifications(context: Context): LiveData<List<Notification>> {
        if (!::notifications.isInitialized) {
            notifications = MutableLiveData()
            GlobalScope.launch(Dispatchers.Main) {
                val notificationsFromDb: List<Notification> = async(Dispatchers.IO) {
                    return@async MyDatabase.get(context).notifications().getAll()
                }.await()
                notifications.postValue(notificationsFromDb)
            }
        }
        return notifications
    }

}