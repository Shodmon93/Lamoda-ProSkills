package com.example.lamoda_v2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lamoda_v2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBarrConfiguration: AppBarConfiguration
    private lateinit var sideNavBarrConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setSupportActionBar(binding.appBarrLayout.toolBar)
        val mainContent = binding.appBarrLayout.mainContentLayout
        val bottomNavView = binding.appBarrLayout.bottomNavView
        val navView: NavigationView = binding.navView
        val drawerLayout: DrawerLayout = binding.drawer
        val navController = findNavController(R.id.nav_host_fragment_content_main)



        bottomNavBarrConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_cat,R.id.nav_basket,R.id.nav_favorite
            )
        )
        sideNavBarrConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_cat,R.id.nav_basket,R.id.nav_favorite
            ),drawerLayout
        )

        setupActionBarWithNavController(navController,bottomNavBarrConfiguration)
        setupActionBarWithNavController(navController,sideNavBarrConfiguration)
        bottomNavView.setupWithNavController(navController)
        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(sideNavBarrConfiguration) || super.onSupportNavigateUp()
    }
}