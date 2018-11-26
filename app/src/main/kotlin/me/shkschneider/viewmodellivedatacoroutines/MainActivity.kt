package me.shkschneider.viewmodellivedatacoroutines

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    private val gson by lazy {
        GsonBuilder().setPrettyPrinting().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_users -> viewModel.loadUsers()
                R.id.navigation_projects -> viewModel.loadProjects()
                R.id.navigation_notifications -> viewModel.loadNotifications()
                else -> return@OnNavigationItemSelectedListener false
            }
            return@OnNavigationItemSelectedListener true
        })
        navigation.selectedItemId = R.id.navigation_users

        viewModel.users.observe(this, Observer {
            display(it)
        })
        viewModel.projects.observe(this, Observer {
            display(it)
        })
        viewModel.notifications.observe(this, Observer {
            display(it)
        })
    }

    private fun <T: Any> display(items: T) {
        message.text = gson.toJson(items)
    }

}
