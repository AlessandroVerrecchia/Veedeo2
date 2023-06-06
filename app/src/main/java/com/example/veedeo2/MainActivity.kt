package com.example.veedeo2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.main_activity.bottomNavView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView.setupWithNavController(navController)
        handleBottomNavItemReselection(navController)
        addDestinationChangeListener(navController)
    }

    private fun handleBottomNavItemReselection(navController: NavController) {
        bottomNavView.setOnItemReselectedListener { menuItem ->
            navController.navigate(menuItem.itemId)
        }
    }

    private fun addDestinationChangeListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.videoPlayerFragment -> {
                    bottomNavView.visibility = View.GONE
                }

                else -> {
                    bottomNavView.visibility = View.VISIBLE
                }
            }
        }
    }
}