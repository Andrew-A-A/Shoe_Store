package com.example.ss


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class ShoeListingViewModel : ViewModel() {
    //Declare Shoe List Live Data List
    private var _shoeList = MutableLiveData<MutableList<Shoes>> ()
    val shoeList : LiveData<MutableList<Shoes>>
        get() = _shoeList
    //Add Some Data to the Live Data List
    init {
        val s1 = Shoes("Air Jordan", 40, R.drawable.airjordan, "Nike", "red", 4000)
        val s2 = Shoes("Air Max", 30, R.drawable.air_max, "Nike", "White", 3000)
        val s3 = Shoes("Converse", 30, R.drawable.converse, "Nike", "White", 3000)
        val s4 = Shoes("Energen Plus", 30, R.drawable.energen_plus, "Nike", "White", 3000)
        val s5= Shoes("Converse high Tops", 30, R.drawable.converse_high_tops, "Nike", "White", 3000)
        val s6 = Shoes("Super Star", 30, R.drawable.super_star, "Nike", "White", 3000)
        _shoeList.value= (_shoeList.value?.plus(s1) ?: mutableListOf(s1)) as MutableList<Shoes>?
        _shoeList.value= (_shoeList.value?.plus(s2) ?: mutableListOf(s1)) as MutableList<Shoes>?
        _shoeList.value= (_shoeList.value?.plus(s3) ?: mutableListOf(s1)) as MutableList<Shoes>?
        _shoeList.value= (_shoeList.value?.plus(s4) ?: mutableListOf(s1)) as MutableList<Shoes>?
        _shoeList.value= (_shoeList.value?.plus(s5) ?: mutableListOf(s1)) as MutableList<Shoes>?
        _shoeList.value= (_shoeList.value?.plus(s6) ?: mutableListOf(s1)) as MutableList<Shoes>?
    }
    //Function that add new Shoes to the Live Data list
//    fun addToList(name: String,size: Int, manufacture: String, color: String, price: Int){
//        val newShoes=Shoes(name,size,R.drawable.air_max,manufacture,color,price)
//        _shoeList.value= (_shoeList.value?.plus(newShoes) ?: mutableListOf(newShoes)) as MutableList<Shoes>?
//    }
        fun addToList(newShoes: Shoes){
        _shoeList.value= (_shoeList.value?.plus(newShoes) ?: mutableListOf(newShoes)) as MutableList<Shoes>?
    }


}