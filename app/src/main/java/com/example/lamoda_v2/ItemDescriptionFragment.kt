package com.example.lamoda_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lamoda_v2.catalog.CatalogViewModel
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.databinding.FragmentItemDescriptionBinding

class ItemDescriptionFragment : Fragment() {
    private lateinit var binding : FragmentItemDescriptionBinding
    private lateinit var manItemViewModel: CatalogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentItemDescriptionBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        manItemViewModel = ViewModelProvider(requireActivity())[CatalogViewModel::class.java]
        manItemViewModel.homeData.observe(viewLifecycleOwner){data->
            data.forEach {
                it.imageView?.forEach {s->
                    Glide.with(binding.root)
                        .load(s.urls?.regular)
                        .into(binding.desImage)
                }
                binding.desText.text = it.tittle
            }
        }





        super.onViewCreated(view, savedInstanceState)
    }
}