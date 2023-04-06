package com.example.lamoda_v2.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.R
import com.example.lamoda_v2.adapters.homeAdapter.HomeMainAdapter
import com.example.lamoda_v2.adapters.recyclerView.RecyclerViewAdapter
import com.example.lamoda_v2.catalog.CatalogViewModel
import com.example.lamoda_v2.databinding.FragmentHomeBinding
import com.example.lamoda_v2.man.viewModel.ManItemViewModel
import com.example.lamoda_v2.viewHolder.HomeRecyclerViewHolder

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var manItemViewModel: CatalogViewModel
    private lateinit var adapter: HomeMainAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manItemViewModel = ViewModelProvider(requireActivity())[CatalogViewModel::class.java]
        initUi()

    }

    private fun initUi() {
        recyclerView = binding.homeRecyclerView
        adapter = HomeMainAdapter{
            item ->
            Navigation.findNavController(binding.root).navigate(R.id.action_nav_home_to_itemDescriptionFragment)
        }
        manItemViewModel.homeData.observe(viewLifecycleOwner , Observer{data ->
            adapter.submitList(data)
        })
        recyclerView.adapter = adapter

    }

}