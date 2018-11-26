package me.shkschneider.viewmodellivedatacoroutines

import android.content.Context
import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
            Coroutines.ioThenMain({
                DataManager.getUsers(context)
            }) {
                users.postValue(it)
            }
        }
        return users
    }

    private lateinit var projects: MutableLiveData<List<Project>>

    @UiThread
    fun getProjects(context: Context): LiveData<List<Project>> {
        if (!::projects.isInitialized) {
            projects = MutableLiveData()
            Coroutines.ioThenMain({
                DataManager.getProjects(context)
            }) {
                projects.postValue(it)
            }
        }
        return projects
    }

    private lateinit var notifications: MutableLiveData<List<Notification>>

    @UiThread
    fun getNotifications(context: Context): LiveData<List<Notification>> {
        if (!::notifications.isInitialized) {
            notifications = MutableLiveData()
            Coroutines.ioThenMain({
                DataManager.getNotifications(context)
            }) {
                notifications.postValue(it)
            }
        }
        return notifications
    }

}