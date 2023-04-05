package com.example.lamoda_v2.man.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.man.viewModel.ManItemViewModel
import com.example.lamoda_v2.databinding.FragmentManItemBinding
import com.example.lamoda_v2.adapters.recyclerView.RecyclerViewAdapter

class ManItemFragment : Fragment() {

    private lateinit var binding: FragmentManItemBinding
    private lateinit var manItemViewModel: ManItemViewModel
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manItemViewModel = ViewModelProvider(requireActivity())[ManItemViewModel::class.java]
        initUi()
      //  observeData()

    }

    private fun initUi() {
        recyclerView = binding.tecyclerView
        adapter = RecyclerViewAdapter(requireActivity())
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

    }

//    private fun observeData() {
//        manItemViewModel.getManItemData.observe(viewLifecycleOwner, Observer {
//            adapter.setData(it)
//        })
//        manItemViewModel.getStoryItemData.observe(viewLifecycleOwner, Observer {
//            adapter.setStoryItemData(it)
//        })
//        Log.d("ViewModel getManItemData", "${manItemViewModel.getManItemData.value}")
//    }
}