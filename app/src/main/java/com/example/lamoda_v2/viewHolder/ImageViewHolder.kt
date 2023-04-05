package com.example.lamoda_v2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.databinding.CatalogImageItemBinding

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = CatalogImageItemBinding.bind(view)
    fun bind(catalogRViewData: CatalogRViewData) {
        Glide.with(binding.root)
            .load(catalogRViewData.imageView)
            .into(binding.seasonImage)
        binding.seasonTittle.visibility = View.GONE
    }
}
