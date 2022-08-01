package com.Akagra.wallettracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CurrencyNotes")
class CurrencyNotes(@PrimaryKey @ColumnInfo(name = "value")val value:Int,
               @ColumnInfo(name = "count")val count:Int)

@Entity(tableName = "CurrencyCoins")
class CurrencyCoins(@PrimaryKey @ColumnInfo(name = "value")val value: Int,
                    @ColumnInfo(name = "count")val count:Int)

