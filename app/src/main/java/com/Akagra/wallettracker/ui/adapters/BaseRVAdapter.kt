package com.Akagra.wallettracker.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Akagra.wallettracker.R

abstract class BaseRVAdapter(private val context: Context) : RecyclerView.Adapter<BaseViewHolder>() {
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder

    abstract override fun onBindViewHolder(holder: BaseViewHolder, position: Int)

    abstract override fun getItemCount(): Int
}

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val currencyItemTotal:TextView = itemView.findViewById(R.id.currencyItemTotal)
    val currencyItemValue:TextView = itemView.findViewById(R.id.currencyItemValue)
    val currencyItemCount:TextView = itemView.findViewById(R.id.currencyItemCount)
    val addButton:ImageView = itemView.findViewById(R.id.addButton)
    val subtractButton:ImageView = itemView.findViewById(R.id.subtractButton)
}

