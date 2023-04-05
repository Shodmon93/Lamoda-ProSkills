package com.example.lamoda_v2.woman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lamoda_v2.databinding.FragmentWomanItemBinding
import com.example.lamoda_v2.adapters.recyclerView.RecyclerViewAdapter

class WomanItemFragment : Fragment() {

    private lateinit var binding : FragmentWomanItemBinding
    val myTab : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myTab.add("One")
        myTab.add("Two")
        myTab.add("Three")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWomanItemBinding.inflate(layoutInflater)

        val adapter = RecyclerViewAdapter(requireActivity())
        val mainRecyclerView = binding.tecyclerView2
        mainRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        mainRecyclerView.adapter = adapter
       // adapter.setData(myTab)


        return binding.root
    }

}