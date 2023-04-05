package com.example.lamoda_v2.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogBinding.inflate(inflater, container, false)



        return binding.root
    }

    fun getBrandData(): ArrayList<Brand> {
        val item: ArrayList<Brand> = ArrayList()
        repeat(9) {
            item.add(
                Brand(
                    "https://picsum.photos/200/300"
                )
            )
            item.add(Brand("https://picsum.photos/200/300"))
        }
        return item

    }

    fun getSeasonData(): List<Season> {
        val item: ArrayList<Season> = ArrayList()

        item.add(Season("https://picsum.photos/200/300", "Nike"))
        item.add(
            Season(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQedKQeZ69cNPkrybiy3aV-CbqjmqnQEx9-yQ&usqp=CAU",
                "Adidas"
            )
        )

        return item
    }

    fun getImageData(): String {
        val item = "https://picsum.photos/200/300"
        return item
    }

    fun getData(): List<CatalogRViewData> {
        val item: ArrayList<CatalogRViewData> = ArrayList()
        repeat(9) {
            item.add(CatalogRViewData(getBrandData(), null, null))
            item.add(CatalogRViewData(null, getSeasonData(), null))
            item.add(CatalogRViewData(null, null, getImageData()))
        }
        return item
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        manItemViewModel = ViewModelProvider(requireActivity())[ManItemViewModel::class.java]
        adapter = MainAdapter()
        adapter.submitList(getData())
        binding.catalogRecyclerView.adapter = adapter

        super.onViewCreated(view, savedInstanceState)

    }

}