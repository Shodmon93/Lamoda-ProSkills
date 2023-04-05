package com.example.lamoda_v2.adapters.homeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.HomeRViewData
import com.example.lamoda_v2.viewHolder.HomeImageHolder
import com.example.lamoda_v2.viewHolder.HomeRecyclerViewHolder

class HomeMainAdapter : ListAdapter<HomeRViewData,ViewHolder>(HomeRVDataDiffUtil()) {


    companion object {
        const val HOME_H_RECYCLER_VIEW = 1
        const val IMAGE = 2
        class HomeRVDataDiffUtil : DiffUtil.ItemCallback<HomeRViewData>(){
            override fun areItemsTheSame(oldItem: HomeRViewData, newItem: HomeRViewData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: HomeRViewData,
                newItem: HomeRViewData
            ): Boolean {
               return oldItem == newItem

            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).recyclerView != null)
            HOME_H_RECYCLER_VIEW
        else
            IMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return when(viewType){
           HOME_H_RECYCLER_VIEW -> HomeRecyclerViewHolder(LayoutInflater.from(parent.context)
               .inflate(R.layout.home_horizontal_recycler_view,parent,false))
           else -> HomeImageHolder(LayoutInflater.from(parent.context)
               .inflate(R.layout.home_recycler_view_item,parent,false))
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       when(holder){
           is HomeRecyclerViewHolder -> holder.bind(getItem(position))
           is HomeImageHolder -> holder.bind(getItem(position))

       }
    }
}