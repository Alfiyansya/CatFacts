package com.alfiansyah.catfacts.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfiansyah.catfacts.data.repository.CatFactRepository
import com.alfiansyah.catfacts.model.CatFact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatFactViewModel @Inject constructor(
    private val catFactRepository: CatFactRepository
) : ViewModel(){
    private val _catFact = MutableLiveData<CatFact>()
    val catFact: LiveData<CatFact> = _catFact

    fun loadCatFact(){
        viewModelScope.launch {
            try {
                _catFact.value = catFactRepository.getCatFact()
                Log.d("THISS", _catFact.value!!.fact)
            }catch (e: Exception){
                Log.d("THISS", e.message.toString())
                e.printStackTrace()
            }
        }
    }
}