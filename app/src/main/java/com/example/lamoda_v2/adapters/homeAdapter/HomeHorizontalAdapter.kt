package com.example.lamoda_v2.adapters.homeAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.StoryItemData
import com.example.lamoda_v2.databinding.HomeHorizontalRecyclerViewBinding
import com.example.lamoda_v2.databinding.HomeHorizontalRecyclerViewItemBinding
import com.example.lamoda_v2.viewHolder.HomeRecyclerViewHolder

class HomeHorizontalAdapter : ListAdapter<StoryItemData,HomeHorizontalAdapter.HomeViewHolder>(StoryItemDiffUtil()){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHorizontalAdapter.HomeViewHolder {
      return HomeViewHolder(LayoutInflater.from(parent.context)
          .inflate(R.layout.home_horizontal_recycler_view_item,parent,false))
    }

    override fun onBindViewHolder(holder: HomeHorizontalAdapter.HomeViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class HomeViewHolder(view:View) : ViewHolder(view){
        val binding = HomeHorizontalRecyclerViewItemBinding.bind(view)

        fun bind(storyItemData: StoryItemData){

            Glide.with(binding.root)
                .load(storyItemData.image)
                .into(binding.storyPhoto)
            binding.storyTextView.text = storyItemData.title

        }
    }

    companion object {
        class StoryItemDiffUtil : DiffUtil.ItemCallback<StoryItemData>(){
            override fun areItemsTheSame(oldItem: StoryItemData, newItem: StoryItemData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: StoryItemData,
                newItem: StoryItemData
            ): Boolean {
              return oldItem == newItem
            }

        }
    }

}