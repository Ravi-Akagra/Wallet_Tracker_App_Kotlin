package com.Akagra.wallettracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.Akagra.wallettracker.data.CurrencyCoins
import com.Akagra.wallettracker.data.CurrencyNotes


//data class CombinedCurrency(val value:Int,val count:Int,val isNote:Boolean)
data class CombinedCurrency(val first:List<CurrencyNotes>,val second:List<CurrencyCoins>)

class CurrencyDataMediator(private val viewModel: CurrencyViewModel) {
     fun createLiveDataMediator(): LiveData<CombinedCurrency> {

        val result = MediatorLiveData<CombinedCurrency>()

        val firstLiveData = viewModel.allNotes
        val secondLiveData = viewModel.allCoins

        result.addSource(firstLiveData) {
            result.value = firstLiveData.value?.let { it1 -> secondLiveData.value?.let { it2 ->
                CombinedCurrency(it1,
                    it2
                )
            } }
// waste code for future me to not do same mistake:

//            result.value?.clear()
//            for (i in it){
//                val a = CombinedCurrency(i.value,i.count,true)
//                result.value?.add(a)
//            }
//            for (i in secondLiveData.value!!){
//                val b = CombinedCurrency(i.value,i.count,false)
//                result.value?.add(b)
//            }
        }
        result.addSource(secondLiveData) {
            result.value = firstLiveData.value?.let { it1 -> secondLiveData.value?.let { it2 ->
                CombinedCurrency(it1,
                    it2
                )
            } }
        }

        return result
    }
}