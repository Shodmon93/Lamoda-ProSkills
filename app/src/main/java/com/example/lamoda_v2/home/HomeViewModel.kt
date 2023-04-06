package com.example.lamoda_v2.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lamoda_v2.data.Brand
import com.example.lamoda_v2.data.CatalogRViewData
import com.example.lamoda_v2.data.HomeRViewData
import com.ru.gridrecyclerview.Api.UnsplashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel : ViewModel()  {

//    private val _data = MutableLiveData<List<HomeRViewData>>()
//    val data get() = _data
//
//    val status = MutableLiveData<Boolean>()
//
//    private val retrofit = UnsplashApi.retrofitService
//
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            status.postValue(true)
//            val list = mutableListOf<HomeRViewData>()
//            try {
//                val brands: List<Brand> = retrofit.getBrands()
//                val season = retrofit.getSeason()
//                val randomPicture = Random.nextInt(10)
//                val image = retrofit.getImage()[randomPicture].urls.regular
//                repeat(5){
//                    list.add(HomeRViewData(brands))
//                    list.add(HomeRViewData(null,null,season))
//                    list.add(HomeRViewData(null,null,image))
//                }
//            }catch (e : Exception){
//                status.postValue(false)
//            }
//            _data.postValue(list)
//        }
//    }
}