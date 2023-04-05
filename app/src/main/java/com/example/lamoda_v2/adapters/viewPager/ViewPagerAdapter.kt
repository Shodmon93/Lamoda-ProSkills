package com.example.lamoda_v2.adapters.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lamoda_v2.catalog.CatalogFragment
import com.example.lamoda_v2.data.ManItemData
import com.example.lamoda_v2.man.fragments.ManItemFragment
import com.example.lamoda_v2.woman.WomanItemFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val picList : ArrayList<ManItemData> = ArrayList()

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> CatalogFragment()
            1 -> CatalogFragment()
            else -> CatalogFragment()
        }


    }

}