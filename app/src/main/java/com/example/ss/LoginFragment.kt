package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.ss.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    //
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)
        //Set On click Listener for Login & Register Buttons
        binding.loginButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        binding.registerButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
      return binding.root

    }
}