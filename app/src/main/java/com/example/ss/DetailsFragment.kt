package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.ss.databinding.FragmentDetailsBinding
class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Declare and initialize viewModel variable
        val viewModel: ShoeListingViewModel by activityViewModels()
        // Declare and initialize viewModel variable
        val binding=FragmentDetailsBinding.inflate(inflater,container,false)
        //Set the binding Life Cycle Owner
        binding.lifecycleOwner=viewLifecycleOwner

        //Set Click listener for Cancel Button
        binding.cancelButton.setOnClickListener { btn ->
            //Navigate to List View
        btn.findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }
        //Set Click listener for Save Button
        binding.saveButton.setOnClickListener { btn ->
            //Check if the Data Entered is Null
            if (binding.priceEditText.text.toString()!="") {
                //Add New Shoes Live Data list in viewModel
                viewModel.addToList(
                    binding.nameEditText.text.toString(),
                    binding.sizeEditText.text.toString().toInt(),
                    binding.manufactureText.text.toString(),
                    binding.colorEditText.text.toString(),
                    binding.priceEditText.text.toString().toInt()
                )
            }
            //Navigate to List View
            btn.findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}