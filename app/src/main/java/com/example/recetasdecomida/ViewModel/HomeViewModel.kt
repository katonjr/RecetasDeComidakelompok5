package com.example.recetasdecomida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recetasdecomida.Model.ModelClass.IsiResepModel
import com.example.recetasdecomida.listRekomendasi

class HomeViewModel : ViewModel() {
    var _listRekomendasi: MutableLiveData<List<IsiResepModel>> = MutableLiveData(listRekomendasi)

    val getListRekomendasi: LiveData<List<IsiResepModel>>
        get() = _listRekomendasi
}