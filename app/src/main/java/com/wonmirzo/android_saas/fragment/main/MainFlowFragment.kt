package com.wonmirzo.android_saas.fragment.main

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.wonmirzo.android_saas.R
import com.wonmirzo.android_saas.databinding.FragmentMainFlowBinding
import com.wonmirzo.android_saas.fragment.BaseFlowFragment

class MainFlowFragment :
    BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)

    override fun setupNavigation(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }

}