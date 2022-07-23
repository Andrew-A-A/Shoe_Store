package com.example.ss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.ss.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // A top-level container for window content
    private lateinit var drawerLayout: DrawerLayout
   //Configuration options for NavigationUI
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Declare Data Binding Variable and initialize it
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //initialize Drawer layout using binding
        drawerLayout = binding.drawerLayout
        //Declare navigation controller and initialize it
        val navController = this.findNavController(R.id.myNavHostFragment)
        //Set Up the Navigation UI
        NavigationUI.setupActionBarWithNavController(this, navController)
        //Configure the app Bar
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
    }
    //Add Navigation Up support
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}