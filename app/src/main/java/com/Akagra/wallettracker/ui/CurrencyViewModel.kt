package com.Akagra.wallettracker.ui

import android.app.Application
import androidx.lifecycle.*
import com.Akagra.wallettracker.data.CurrencyCoins
import com.Akagra.wallettracker.data.CurrencyDataBase
import com.Akagra.wallettracker.data.CurrencyNotes
import com.Akagra.wallettracker.data.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CurrencyViewModel(application: Application): AndroidViewModel(application) {
    private val repository:CurrencyRepository

    init {
        val dao = CurrencyDataBase.getDataBase(application).getDao()
        repository = CurrencyRepository(dao)
    }

    val allNotes: LiveData<List<CurrencyNotes>> = repository.allNotes
    val allCoins: LiveData<List<CurrencyCoins>> = repository.allCoins


//    fun getNoteCount(value:Int){
//        repository.getNoteCount(value)
//    }
//    fun getCoinCount(value: Int){
//        repository.getCoinCount(value)
//    }
    fun incrementNotes(value: Int,prevCnt:Int)= viewModelScope.launch{
        repository.incrementNotes(value,prevCnt)
    }
    fun incrementCoins(value: Int,prevCnt: Int)=viewModelScope.launch(Dispatchers.IO){
        repository.incrementCoins(value,prevCnt)
    }

    fun decrementNotes(value: Int,prevCnt: Int) = viewModelScope.launch(Dispatchers.IO){
        repository.decrementNotes(value,prevCnt)
    }
    fun decrementCoins(value: Int,prevCnt: Int) = viewModelScope.launch(Dispatchers.IO){
        repository.decrementCoins(value,prevCnt)
    }



}