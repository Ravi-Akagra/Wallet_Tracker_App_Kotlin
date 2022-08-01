package com.Akagra.wallettracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface CurrencyDAO {

    @Query("SELECT * FROM CurrencyNotes ORDER BY value ASC")
    fun getAllNotes(): LiveData<List<CurrencyNotes>>

    @Query("SELECT * FROM CurrencyCoins ORDER BY value ASC")
    fun getAllCoins(): LiveData<List<CurrencyCoins>>

//    @Query("SELECT count FROM CurrencyNotes WHERE value=:value ")
//    fun getNoteCount(value:Int): Int
//
//    @Query("SELECT count FROM CurrencyCoins WHERE value=:value ")
//    fun getCoinCount(value:Int): Int

    @Update
    suspend fun updateNotes(Note:CurrencyNotes)

    @Update
    suspend fun updateCoins(Coin:CurrencyCoins)

//    @Query("UPDATE CurrencyNotes SET count=count+1 Where value=:value ")
//    fun incrementNotes(value:Int)
//
//    @Query("UPDATE CurrencyCoins SET count=count+1 Where value=:value ")
//    fun incrementCoins(value:Int)
//
//    @Query("UPDATE CurrencyNotes SET count=count-1 Where value=:value ")
//    fun decrementNotes(value:Int)
//
//    @Query("UPDATE CurrencyCoins SET count=count-1 Where value=:value ")
//    fun decrementCoins(value:Int)
}