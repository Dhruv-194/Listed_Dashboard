package com.dhruv194.listed_dashboard.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dhruv194.listed_dashboard.ui.fragments.RecentLinksFragment
import com.dhruv194.listed_dashboard.ui.fragments.TopLinksFragment

class ViewPagerAdapter (fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->TopLinksFragment()
            1->RecentLinksFragment()

            else->{
                TopLinksFragment()
            }
        }
    }

}