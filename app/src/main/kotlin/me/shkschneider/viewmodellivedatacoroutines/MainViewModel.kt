package me.shkschneider.viewmodellivedatacoroutines

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.shkschneider.viewmodellivedatacoroutines.data.Notification
import me.shkschneider.viewmodellivedatacoroutines.data.Project
import me.shkschneider.viewmodellivedatacoroutines.data.User

class MainViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    @UiThread
    fun loadUsers(): LiveData<List<User>> {
        Coroutines.ioThenMain({
            DataManager.getUsers()
        }) {
            _users.value = it
        }
        return users
    }

    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>> get() = _projects

    @UiThread
    fun loadProjects(): LiveData<List<Project>> {
        Coroutines.ioThenMain({
            DataManager.getProjects()
        }) {
            _projects.value = it
        }
        return projects
    }

    private val _notifications = MutableLiveData<List<Notification>>()
    val notifications: LiveData<List<Notification>> get() = _notifications

    @UiThread
    fun loadNotifications(): LiveData<List<Notification>> {
        Coroutines.ioThenMain({
            DataManager.getNotifications()
        }) {
            _notifications.value = it
        }
        return notifications
    }

}