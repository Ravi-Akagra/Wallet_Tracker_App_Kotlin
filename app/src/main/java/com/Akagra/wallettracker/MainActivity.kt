package com.Akagra.wallettracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.Akagra.wallettracker.databinding.ActivityMainBinding
import com.Akagra.wallettracker.ui.CurrencyDataMediator
import com.Akagra.wallettracker.ui.CurrencyViewModel
import com.Akagra.wallettracker.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currencyViewModel: CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        currencyViewModel = ViewModelProvider(this).get(CurrencyViewModel::class.java)

        val tabLayout = binding.tabs
        val viewPager2 = binding.viewPager
        val combinedCurrency = CurrencyDataMediator(viewModel=currencyViewModel).createLiveDataMediator()

        val adapter = ViewPagerAdapter(this)
        viewPager2.setAdapter(adapter)

        combinedCurrency.observe(this){
            it?.let {
                val notes = it.first
                val coins = it.second

                var noteSum = 0
                var coinSum = 0

                for (i in notes){
                    noteSum += i.value*i.count
                }

                for (i in coins){
                    coinSum += i.value*i.count
                }

                binding.totalAmount.text = buildString {
        append(noteSum+coinSum)
    }
                TabLayoutMediator(
                    tabLayout, viewPager2){ tab, position ->

                    tab.text = when (position) {
                        0 -> "Notes($noteSum)"

                        1 ->"Coins($coinSum)"
                        else -> ""
                    }
                }.attach()
            }
        }
    }
}