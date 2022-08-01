package com.Akagra.wallettracker.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.Akagra.wallettracker.R
import com.Akagra.wallettracker.data.CurrencyNotes

class NotePageRVAdapter(private val context: Context,private val listener:INoteRVAdapter) : BaseRVAdapter(context) {

    val allNotes = ArrayList<CurrencyNotes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewHolder = BaseViewHolder(LayoutInflater.from(context).inflate(R.layout.currency_item,
            parent,false))
        viewHolder.addButton.setOnClickListener{
            listener.onAddButtonClicked(allNotes[viewHolder.adapterPosition])
        }
        viewHolder.subtractButton.setOnClickListener{
            listener.onSubtractButtonClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
       val currentNode = allNotes[position]
        holder.currencyItemValue.text = currentNode.value.toString()
        holder.currencyItemCount.text = if (currentNode.count>99) "99+" else currentNode.count.toString()
        holder.currencyItemTotal.text = (currentNode.value*currentNode.count).toString()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<CurrencyNotes>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface INoteRVAdapter{
    fun onAddButtonClicked(note:CurrencyNotes)
    fun onSubtractButtonClicked(note: CurrencyNotes)
}