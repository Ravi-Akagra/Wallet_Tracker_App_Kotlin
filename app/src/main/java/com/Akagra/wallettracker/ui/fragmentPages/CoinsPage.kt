package com.Akagra.wallettracker.ui.fragmentPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.Akagra.wallettracker.data.CurrencyCoins
import com.Akagra.wallettracker.databinding.FragmentCoinsPageBinding
import com.Akagra.wallettracker.ui.CoinPageRVAdapter
import com.Akagra.wallettracker.ui.CurrencyViewModel
import com.Akagra.wallettracker.ui.ICoinRVAdapter


class CoinsPage : Fragment(), ICoinRVAdapter {
    private lateinit var coinBinding: FragmentCoinsPageBinding
    private lateinit var viewModel: CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coinBinding = FragmentCoinsPageBinding.inflate(layoutInflater)
        viewModel =  ViewModelProvider(this).get(CurrencyViewModel::class.java)

        val recyclerView = coinBinding.coinRecyclerView
        val adapter = this.context?.let { CoinPageRVAdapter(it,this) }
        recyclerView.adapter = adapter

        viewModel.allCoins.observe(this) {
            it?.let {
                println("$it alex")
                adapter?.updateList(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return coinBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CoinsPage()
    }

    override fun onAddButtonClicked(coin: CurrencyCoins) {
        viewModel.incrementCoins(coin.value,coin.count)
    }

    override fun onSubtractButtonClicked(coin: CurrencyCoins) {
        viewModel.decrementCoins(coin.value,coin.count)
    }
}