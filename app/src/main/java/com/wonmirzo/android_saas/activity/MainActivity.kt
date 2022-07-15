package com.wonmirzo.android_saas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.wonmirzo.android_saas.R
import com.wonmirzo.android_saas.databinding.ActivityMainBinding
import com.wonmirzo.android_saas.manager.AuthManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            AuthManager.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
            !AuthManager.isAuthorized -> {
                navGraph.setStartDestination(R.id.loginFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}