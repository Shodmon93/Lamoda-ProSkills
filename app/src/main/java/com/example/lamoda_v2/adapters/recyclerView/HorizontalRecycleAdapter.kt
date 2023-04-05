package com.example.lamoda_v2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.StoryItemData
import com.example.lamoda_v2.databinding.HorizontalRecyclerviewLayoutBinding

class HorizontalRecycleAdapter :
    ListAdapter<StoryItemData, HorizontalRecycleAdapter
    .StoryItemViewHolder>(StoryItemDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryItemViewHolder {
        return StoryItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.horizontal_recyclerview_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StoryItemViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

//    fun setData(itemData: ArrayList<StoryItemData>){
//        this.item = itemData
//        notifyDataSetChanged()
//    }

    inner class StoryItemViewHolder(view: View) : ViewHolder(view) {
        val binding = HorizontalRecyclerviewLayoutBinding.bind(view)

        fun bindData(storyItemData: StoryItemData) {
            binding.storyPhoto.setImageResource(storyItemData.image)
            binding.textView.text = storyItemData.title
        }

    }
}

class StoryItemDiffUtil : DiffUtil.ItemCallback<StoryItemData>() {
    override fun areItemsTheSame(oldItem: StoryItemData, newItem: StoryItemData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: StoryItemData, newItem: StoryItemData): Boolean {
        return oldItem.id == newItem.id
    }


}