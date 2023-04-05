package com.example.lamoda_v2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.adapters.catalogAdapter.ViewPagerAdapter
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.databinding.CatalogViewPagerBinding


class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = CatalogViewPagerBinding.bind(view)
    private val adapter = ViewPagerAdapter()

    fun bind(catalogRViewData: CatalogRViewData) {
        binding.seasonViewPager.adapter = adapter
        adapter.submitList(catalogRViewData.viewPager)

    }
}