package com.dgsw.hackathon.moira.view.activtiy

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dgsw.hackathon.moira.R
import com.dgsw.hackathon.moira.widget.extension.setStatusMode
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        setStatusMode()
        val navController = findNavController(R.id.nav_host_fragment)
        nav_view.setupWithNavController(navController)
    }
}