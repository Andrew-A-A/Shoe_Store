package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ss.databinding.FragmentCardBinding

class CardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Declare and initialize Data Binding variable
        val binding = DataBindingUtil.inflate<FragmentCardBinding>(inflater,R.layout.fragment_card,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
}