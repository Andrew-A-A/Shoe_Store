package com.example.ss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.ss.databinding.FragmentDetailsBinding
class DetailsFragment : Fragment(){
lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Declare and initialize viewModels variables
        val shoeViewModel: ShoeListingViewModel by activityViewModels()
        val viewModel = DetailsViewModel()
        // Declare and initialize viewModel variable
        val binding=FragmentDetailsBinding.inflate(inflater,container,false)
        binding.viewModel=viewModel

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
                //Change Entered "Price" & "Size" data type to Integer
                val price=binding.priceEditText.text.toString().toInt()
                val size=binding.sizeEditText.text.toString().toInt()
                viewModel.newShoes.value?.price=price
                viewModel.newShoes.value?.size=size
                //Add New Shoes Live Data list in viewModel
                viewModel.newShoes.value?.let { shoeViewModel.addToList(it) }
            }
            //Navigate to List View
            btn.findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}