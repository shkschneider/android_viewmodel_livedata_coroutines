package me.shkschneider.viewmodellivedatacoroutines

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

class MainViewModel : ViewModel() {

    private lateinit var users: MutableLiveData<List<User>>

    @UiThread
    fun getUsers(): LiveData<List<User>> {
        if (!::users.isInitialized) {
            users = MutableLiveData()
            Coroutines.ioThenMain({
                DataManager.getUsers()
            }) {
                users.postValue(it)
            }
        }
        return users
    }

    private lateinit var projects: MutableLiveData<List<Project>>

    @UiThread
    fun getProjects(): LiveData<List<Project>> {
        if (!::projects.isInitialized) {
            projects = MutableLiveData()
            Coroutines.ioThenMain({
                DataManager.getProjects()
            }) {
                projects.postValue(it)
            }
        }
        return projects
    }

    private lateinit var notifications: MutableLiveData<List<Notification>>

    @UiThread
    fun getNotifications(): LiveData<List<Notification>> {
        if (!::notifications.isInitialized) {
            notifications = MutableLiveData()
            Coroutines.ioThenMain({
                DataManager.getNotifications()
            }) {
                notifications.postValue(it)
            }
        }
        return notifications
    }

}