package com.example.lamoda_v2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lamoda_v2.data.HomeRViewData
import com.example.lamoda_v2.databinding.HomeRecyclerViewItemBinding

class HomeImageHolder (view:View) : RecyclerView.ViewHolder(view) {
    val binding = HomeRecyclerViewItemBinding.bind(view)

    fun bind(homeRViewData: HomeRViewData){
        Glide.with(binding.root)
            .load(homeRViewData.imageView)
            .into(binding.firstPicture)
        Glide.with(binding.root)
            .load(homeRViewData.imageView)
            .into(binding.firstPicture)
        binding.firstTittle.text = homeRViewData.tittle
        binding.secondTittle.text = homeRViewData.tittle
    }
}