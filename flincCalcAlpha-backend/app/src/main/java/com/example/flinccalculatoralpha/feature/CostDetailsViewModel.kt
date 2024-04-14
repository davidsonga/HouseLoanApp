package com.example.flinccalculatoralpha.feature


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CostDetailsViewModel : ViewModel() {
    val costDetails: MutableLiveData<CostDetails?> = MutableLiveData()
}
