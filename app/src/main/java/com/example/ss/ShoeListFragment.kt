package com.example.ss

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.ss.databinding.FragmentCardBinding
import com.example.ss.databinding.FragmentShoeListBinding


@Suppress("DEPRECATION", "NAME_SHADOWING")
class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    //Declare and initialize view model
    private val viewModel: ShoeListingViewModel by activityViewModels()
    //Declare Linear Layout variable
    private lateinit var linearLayout: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Initialize binding variable
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        //Initialize Linear layout variable
       linearLayout=binding.linearLayout
        //Set Life Cycle Owner
       binding.lifecycleOwner=viewLifecycleOwner
        //Set Observer to Life Data List
     viewModel.shoeList.observe(viewLifecycleOwner){shoes->
        //Set Each Card view Data and inflate it
         shoes.forEachIndexed{ _, shoes ->
             val shoeBinding=FragmentCardBinding.inflate(LayoutInflater.from(requireContext()))
              shoeBinding.root.layoutParams=LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,
             LinearLayout.LayoutParams.WRAP_CONTENT)
             shoeBinding.nameView.text=shoes.name
             shoeBinding.imageView.setImageResource(shoes.photo)
            linearLayout.addView(shoeBinding.root)
         }
         //set Click listener floating action button
         binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_detailsFragment2))

     }
        // Inflate the layout for this fragment
          return binding.root
    }
        //Log Out function that navigate to Login View
    private fun logOut(){
        view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_loginFragment)
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //Inflate Menu
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.logout -> {
               logOut()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}