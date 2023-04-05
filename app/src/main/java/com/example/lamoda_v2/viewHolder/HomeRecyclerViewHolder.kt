package com.example.lamoda_v2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.adapters.homeAdapter.HomeHorizontalAdapter
import com.example.lamoda_v2.adapters.homeAdapter.HomeMainAdapter
import com.example.lamoda_v2.data.HomeRViewData
import com.example.lamoda_v2.databinding.HomeHorizontalRecyclerViewBinding

class HomeRecyclerViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    val binding = HomeHorizontalRecyclerViewBinding.bind(view)
    private val adapter = HomeHorizontalAdapter()
    fun bind(homeRViewData: HomeRViewData){
        binding.recyclerView.adapter = adapter
        adapter.submitList(homeRViewData.recyclerView)
    }

}