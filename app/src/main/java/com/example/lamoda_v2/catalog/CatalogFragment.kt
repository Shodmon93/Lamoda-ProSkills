package com.example.lamoda_v2.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.lamoda_v2.adapters.catalogAdapter.MainAdapter
import com.example.lamoda_v2.data.Brand
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.data.Season
import com.example.lamoda_v2.databinding.FragmentCatalogBinding
import com.example.lamoda_v2.man.viewModel.ManItemViewModel

const val ARG_PARAM = "param1"

class CatalogFragment : Fragment() {
    private var param1: Int? = null


    private lateinit var binding: FragmentCatalogBinding
    private lateinit var manItemViewModel: ManItemViewModel
    private lateinit var adapter: MainAdapter

    private val catalogViewModel : CatalogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        manItemViewModel = ViewModelProvider(requireActivity())[ManItemViewModel::class.java]

        adapter = MainAdapter()
        binding.catalogRecyclerView.adapter = adapter

        catalogViewModel.data.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        catalogViewModel.status.observe(viewLifecycleOwner){
            if (it == false){
                //If request fails
             //   binding.progressBar.visibility
                Toast.makeText(requireContext(),"Something went wrong",Toast.LENGTH_SHORT).show()
            } else if (it == true){
                //If request passes it should be true
                // Do something if u want
                binding.progressBar.visibility = View.GONE
            }
        }

        super.onViewCreated(view, savedInstanceState)

    }

}