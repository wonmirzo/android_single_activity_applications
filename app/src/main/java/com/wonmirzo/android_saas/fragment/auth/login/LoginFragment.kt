package com.wonmirzo.android_saas.fragment.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.wonmirzo.android_saas.R
import com.wonmirzo.android_saas.databinding.FragmentLoginBinding
import com.wonmirzo.android_saas.databinding.FragmentSignupBinding
import com.wonmirzo.android_saas.extension.activityNavController
import com.wonmirzo.android_saas.extension.navigateSafely
import com.wonmirzo.android_saas.manager.AuthManager

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            bSignin.setOnClickListener {
                AuthManager.isAuthorized = true
                activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
            }
            tvSignup.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
            }
        }
    }
}