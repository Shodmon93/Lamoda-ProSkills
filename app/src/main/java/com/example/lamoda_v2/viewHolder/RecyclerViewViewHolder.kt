package com.example.lamoda_v2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.adapters.catalogAdapter.CatalogAdapter
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.databinding.CatalogHorizontalRecyclerViewBinding


class RecyclerViewViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = CatalogHorizontalRecyclerViewBinding.bind(view)
    private val adapter = CatalogAdapter()
    fun bind(catalogRViewData: CatalogRViewData) {
        binding.recyclerViewItem.adapter = adapter
        adapter.submitList(catalogRViewData.recyclerView)
    }

}