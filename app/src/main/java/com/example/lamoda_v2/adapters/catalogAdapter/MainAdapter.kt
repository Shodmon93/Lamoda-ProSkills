package com.example.lamoda_v2.adapters.catalogAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.viewHolder.ImageViewHolder
import com.example.lamoda_v2.viewHolder.RecyclerViewViewHolder
import com.example.lamoda_v2.viewHolder.ViewPagerViewHolder

class MainAdapter : ListAdapter<CatalogRViewData, ViewHolder>(MainRvDiffUtil()) {

    override fun getItemViewType(position: Int): Int {

        return if (getItem(position).recyclerView != null)
            RECYCLER_VIEW

        else if (getItem(position).viewPager != null)
            VIEW_PAGER

        else IMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            RECYCLER_VIEW -> RecyclerViewViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.catalog_horizontal_recycler_view, parent, false)
            )
            VIEW_PAGER -> ViewPagerViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.catalog_view_pager, parent, false)
            )
            else -> ImageViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.catalog_image_item, parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is RecyclerViewViewHolder -> holder.bind(getItem(position))
            is ViewPagerViewHolder -> holder.bind(getItem(position))
            is ImageViewHolder -> holder.bind(getItem(position))
        }
    }


    companion object {

        const val RECYCLER_VIEW = 1
        const val VIEW_PAGER = 2
        const val IMAGE = 3


        class MainRvDiffUtil : DiffUtil.ItemCallback<CatalogRViewData>() {
            override fun areItemsTheSame(oldItem: CatalogRViewData, newItem: CatalogRViewData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CatalogRViewData, newItem: CatalogRViewData): Boolean {
                return oldItem == newItem
            }

        }
    }

}


