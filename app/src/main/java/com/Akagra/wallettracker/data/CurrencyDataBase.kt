package com.Akagra.wallettracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(CurrencyNotes::class,CurrencyCoins::class), version = 1, exportSchema = true)
abstract class CurrencyDataBase: RoomDatabase() {

    abstract fun getDao(): CurrencyDAO

    companion object{

        @Volatile
        var INSTANCE: CurrencyDataBase? = null

        fun getDataBase(context: Context):CurrencyDataBase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    CurrencyDataBase::class.java,"CurrencyDB")
                    .createFromAsset("database/CurrencyDB.db").build()
                //TODO("ADD THE DATABASE LOADER PATH HERE")
                INSTANCE = instance
                instance
            }
        }


    }
}