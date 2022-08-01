package com.Akagra.wallettracker.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.Akagra.wallettracker.ui.fragmentPages.CoinsPage
import com.Akagra.wallettracker.ui.fragmentPages.NotesPage


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NotesPage()
            1 -> CoinsPage()
            else -> NotesPage()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}