package com.example.lamoda_v2.adapters.catalogAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.Brand
import com.example.lamoda_v2.databinding.CatalogHorizontalRvItemBinding


class CatalogAdapter : ListAdapter<Brand, CatalogAdapter.CatalogViewHolder>(
    CatalogDiffUtil()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.catalog_horizontal_rv_item, parent, false)
        )
    }


    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = CatalogHorizontalRvItemBinding.bind(view)
        fun bind(brand: Brand){

            Glide.with(binding.root)
                .load(brand.brandImage)
                .into(binding.storyPhoto)

        }

    }
    companion object{
        class CatalogDiffUtil : DiffUtil.ItemCallback<Brand>(){
            override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean {
               return oldItem == newItem
            }

        }
    }

}
