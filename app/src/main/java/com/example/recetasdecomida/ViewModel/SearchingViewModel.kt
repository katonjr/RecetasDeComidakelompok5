package com.example.recetasdecomida.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.listResepFilter

class SearchingViewModel : ViewModel() {
    var listSearching: MutableLiveData<List<ResepSimpanModel>> = MutableLiveData(listResepFilter)

    var searchText: MutableLiveData<String> = MutableLiveData("")

    val getListSearching: LiveData<List<ResepSimpanModel>>
        get() = listSearching

    val getSearchText: LiveData<String>
        get() = searchText

    fun setText(textBaru: String){
        searchText.value = textBaru
    }


}