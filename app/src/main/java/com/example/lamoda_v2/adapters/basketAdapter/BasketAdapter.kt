package com.example.lamoda_v2.adapters.basketAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.ManItemData
import com.example.lamoda_v2.databinding.BasketItemBinding

class BasketAdapter : ListAdapter<ManItemData,BasketAdapter.BasketViewHolder>(BasketDiffUtil()) {

    inner class BasketViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = BasketItemBinding.bind(view)

        fun bind(manItemData: ManItemData){
            Glide.with(binding.root)
                .load(manItemData.picture)
                .into(binding.basketImage)
            binding.itemName.text = manItemData.product
            binding.itemColor.text = "Black"
            binding.itemSize.text = "41"
            binding.itemPrice.text = "230 Somoni"
        }
    }

    companion object{
        class BasketDiffUtil : DiffUtil.ItemCallback<ManItemData>(){
            override fun areItemsTheSame(oldItem: ManItemData, newItem: ManItemData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ManItemData, newItem: ManItemData): Boolean {
               return oldItem == newItem
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
       return BasketViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.basket_item,parent,false))
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}