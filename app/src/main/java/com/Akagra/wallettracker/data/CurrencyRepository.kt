package com.Akagra.wallettracker.data

import androidx.lifecycle.LiveData

class CurrencyRepository(private val currencyDAO: CurrencyDAO) {

    val allNotes:LiveData<List<CurrencyNotes>> = currencyDAO.getAllNotes()
    val allCoins:LiveData<List<CurrencyCoins>> = currencyDAO.getAllCoins()

//    fun getNoteCount(value:Int){
//        currencyDAO.getNoteCount(value)
//    }
//
//    fun getCoinCount(value: Int){
//        currencyDAO.getCoinCount(value)
//    }

    suspend fun incrementNotes(value: Int,prevCnt:Int){
        currencyDAO.updateNotes(CurrencyNotes(value,prevCnt+1))
    }
    suspend fun incrementCoins(value: Int,prevCnt: Int){
        currencyDAO.updateCoins(CurrencyCoins(value,prevCnt+1))
    }

    suspend fun decrementNotes(value: Int,prevCnt: Int){
        if (prevCnt>0){
            currencyDAO.updateNotes(CurrencyNotes(value,prevCnt-1))
        }
    }
    suspend fun decrementCoins(value: Int,prevCnt: Int){
        if (prevCnt>0){
            currencyDAO.updateCoins(CurrencyCoins(value,prevCnt-1))
        }
    }
}