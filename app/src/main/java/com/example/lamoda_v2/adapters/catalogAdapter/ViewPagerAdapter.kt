package com.example.lamoda_v2.adapters.catalogAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.Season
import com.example.lamoda_v2.databinding.CatalogViewPagerItemBinding


class ViewPagerAdapter : androidx.recyclerview.widget.ListAdapter<Season, ViewPagerAdapter.ViewPagerViewHolder>(
    ViewPagerDiffUtil()
) {


    inner class ViewPagerViewHolder(view: View) : ViewHolder(view) {
        val binding = CatalogViewPagerItemBinding.bind(view)

        fun bind (season: Season){
            Glide.with(binding.root)
                .load(season.urls?.regular)
                .into(binding.seasonImage)
            binding.seasonTittle.text = season.alt_description
        }

    }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
           return ViewPagerViewHolder(
               LayoutInflater.from(parent.context)
                   .inflate(R.layout.catalog_view_pager_item,parent,false)
           )
        }

        override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
            holder.bind(getItem(position))
        }


        companion object {
            class ViewPagerDiffUtil : DiffUtil.ItemCallback<Season>() {
                override fun areItemsTheSame(oldItem: Season, newItem: Season): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: Season, newItem: Season): Boolean {
                    return oldItem == newItem
                }

            }
        }

}


