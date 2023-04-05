package com.example.lamoda_v2.adapters.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.R
import com.example.lamoda_v2.adapters.viewPager.ViewPagerAdapter
import com.example.lamoda_v2.data.ManItemData
import com.example.lamoda_v2.data.StoryItemData
import com.example.lamoda_v2.databinding.MainRecyclerViewLayoutBinding
import com.example.lamoda_v2.databinding.RecyclerViewHomeBinding
import com.example.lamoda_v2.ui.HorizontalRecycleAdapter

class RecyclerViewAdapter(val fa : FragmentActivity) : RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder>() {


    private var manItemData: List<ManItemData> = listOf()
    private var storyItem: List<StoryItemData> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return manItemData.size

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(manItemData[position])
        holder.initHorizonRV(manItemData[position])

    }

    fun setData(manData: List<ManItemData>) {
        this.manItemData = manData
        notifyDataSetChanged()
    }

    fun setStoryItemData(storyData: List<StoryItemData>) {
        this.storyItem = storyData
    }


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecyclerViewHomeBinding.bind(view)

        fun bindData(manItemData: ManItemData) {
            binding.homeFirstImage.setImageResource(manItemData.picture)
            binding.homeFirstImageTittle.text = manItemData.product
            binding.homeSecondImage.setImageResource(manItemData.picture)
            binding.homeSecondImageTittle.text = manItemData.product
        }

        fun initHorizonRV(manItemData: ManItemData) {
            val adapter = ViewPagerAdapter(fa)
            adapter.picList.add(manItemData)
            adapter.picList.add(manItemData)
            adapter.picList.add(manItemData)
            binding.homeViewPager.adapter = adapter
//            adapter.submitList(storyItem)
//            binding.tecyclerView3.adapter = adapter

        }

    }

}