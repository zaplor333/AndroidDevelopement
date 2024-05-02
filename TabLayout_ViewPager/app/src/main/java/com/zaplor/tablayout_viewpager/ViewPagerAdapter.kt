package com.zaplor.tablayout_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // Return the Fragment associated with the specified position
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }

    override fun getCount(): Int {
        // Return the total number of tabs
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Return the title of each tab
        return when (position) {
            0 -> "Tab 1"
            1 -> "Tab 2"
            else -> null
        }
    }
}
