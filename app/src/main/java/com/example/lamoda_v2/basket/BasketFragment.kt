package com.example.lamoda_v2.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lamoda_v2.R
import com.example.lamoda_v2.adapters.basketAdapter.BasketAdapter
import com.example.lamoda_v2.databinding.FragmentBasketBinding
import com.example.lamoda_v2.man.viewModel.ManItemViewModel
import com.example.lamoda_v2.model.Model

class BasketFragment : Fragment() {

    private lateinit var adapter : BasketAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var binding: FragmentBasketBinding
    private lateinit var manItemViewModel : ManItemViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        manItemViewModel = ViewModelProvider(requireActivity())[ManItemViewModel::class.java]
        adapter = BasketAdapter()
        manItemViewModel.getManItemData.observe(viewLifecycleOwner) { data ->
            adapter.submitList(data)
        }

        recyclerView = binding.basketRecyclerview
        recyclerView.adapter = adapter
    }

}