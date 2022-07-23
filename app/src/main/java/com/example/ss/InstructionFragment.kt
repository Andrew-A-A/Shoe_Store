package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.ss.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    //Binding Variable
   lateinit var binding : FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Initialize  Binding
      binding= DataBindingUtil.inflate(inflater,R.layout.fragment_instruction,container,false)
      //Set On click click listener for Start shopping  button
        binding.startShoping.setOnClickListener( Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoeListFragment))
        // Inflate the layout for this fragment
        return binding.root
    }
}