package com.Akagra.wallettracker.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.Akagra.wallettracker.R
import com.Akagra.wallettracker.data.CurrencyCoins

class CoinPageRVAdapter(private val context: Context,private val listener:ICoinRVAdapter):BaseRVAdapter(context) {

    val allCoins = ArrayList<CurrencyCoins>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewHolder = BaseViewHolder(LayoutInflater.from(context).inflate(R.layout.currency_item,
            parent,false))
        viewHolder.addButton.setOnClickListener{
            listener.onAddButtonClicked(allCoins[viewHolder.adapterPosition])
        }
        viewHolder.subtractButton.setOnClickListener{
            listener.onSubtractButtonClicked(allCoins[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentNode = allCoins[position]
        holder.currencyItemCount.text = if (currentNode.count>99) "99+" else currentNode.count.toString()
        holder.currencyItemValue.text = currentNode.value.toString()
        holder.currencyItemTotal.text = (currentNode.count*currentNode.value).toString()
    }

    override fun getItemCount(): Int {
       return allCoins.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<CurrencyCoins>) {
        allCoins.clear()
        allCoins.addAll(newList)
        notifyDataSetChanged()
    }
}

interface ICoinRVAdapter{
    fun onAddButtonClicked(coin: CurrencyCoins)
    fun onSubtractButtonClicked(coin: CurrencyCoins)
}