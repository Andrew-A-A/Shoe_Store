package com.example.ss


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DetailsViewModel : ViewModel() {
      var newShoes : MutableLiveData<Shoes> =MutableLiveData(Shoes(" ",0,R.drawable.air_max," "," ",0))
}