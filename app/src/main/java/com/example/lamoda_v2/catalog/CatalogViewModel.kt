package com.example.lamoda_v2.catalog

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lamoda_v2.data.*
import com.ru.gridrecyclerview.Api.UnsplashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class CatalogViewModel : ViewModel() {

    private val _data = MutableLiveData<List<CatalogRViewData>>()
    val data get() = _data

    private val _homeDaataa = MutableLiveData<List<HomeRViewData>>()
    val homeData get() = _homeDaataa

    private val _season = MutableLiveData<Season>()
    val season get() = _season

    val status = MutableLiveData<Boolean>()

    private val retrofit = UnsplashApi.retrofitService


//    StoryItemData(
//    val id : Int,
//    val image: Int,
//    val title : String
//    season.alt_description = tittle
//    brands.alt_description = tittle
    init {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(true)
            val list = mutableListOf<CatalogRViewData>()
            val item = mutableListOf<HomeRViewData>()
            val storyData = mutableListOf<Season>()
           // var story = mutableListOf<StoryItemData>()
            try {


                val randomPicture1 = Random.nextInt(10)
                val image1 = retrofit.getImage()[randomPicture1].urls.regular


                val brands: List<Brand> = retrofit.getBrands()
                val story : List<StoryItemData> = retrofit.getStoryData()
                val season = retrofit.getSeason()
                val randomPicture = Random.nextInt(10)
                val image = retrofit.getImage()[randomPicture].urls.regular
                val text = Random.nextInt(10)
                val tittle = retrofit.getBrands()[text].alt_description
                item.add(HomeRViewData(story))

                repeat(5){
                    list.add(CatalogRViewData(brands))
                    list.add(CatalogRViewData(null,season))
                    list.add(CatalogRViewData(null,null,image))
                    item.add(HomeRViewData(null,season,tittle))
                }
            }catch (e : Exception){
                status.postValue(false)
            }
            _data.postValue(list)
            _homeDaataa.postValue(item)
        }
    }

}