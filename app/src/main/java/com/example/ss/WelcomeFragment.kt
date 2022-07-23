package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.ss.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    //Declare binding variable
    lateinit var binding :FragmentWelcomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        //Initialize binding variable
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        //Set On click Listener for the "Next" Button
        binding.nextButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionFragment))
        // Inflate the layout for this fragment
        return binding.root
    }
}