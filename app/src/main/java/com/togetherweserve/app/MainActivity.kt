package com.togetherweserve.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.togetherweserve.app.databinding.ActivityMainBinding
import com.togetherweserve.app.ui.organiser.CreateEventActivity
import com.togetherweserve.app.utils.SessionManager

/**
 * Hosts the bottom-navigation shell (Home, My Schedule, Notifications,
 * Profile, Settings) shown in the navigation diagram. An extra
 * "Create Event" FAB is revealed for users with the organiser role.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        val session = SessionManager(this)
        if (session.role == "organiser") {
            binding.fabCreateEvent.visibility = android.view.View.VISIBLE
            binding.fabCreateEvent.setOnClickListener {
                startActivity(Intent(this, CreateEventActivity::class.java))
            }
        }
    }
}
