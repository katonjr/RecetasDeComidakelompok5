package com.example.recetasdecomida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.listResep

class ResepSimpanViewModel : ViewModel() {

    var _listResep : MutableLiveData<List<ResepSimpanModel>> = MutableLiveData(listResep)

    val getListResep: LiveData<List<ResepSimpanModel>>
        get() = _listResep
}