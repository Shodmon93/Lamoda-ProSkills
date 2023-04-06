package com.example.lamoda_v2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lamoda_v2.R
import com.example.lamoda_v2.data.Brand
import com.example.lamoda_v2.data.HomeRViewData
import com.example.lamoda_v2.data.ManItemData
import com.example.lamoda_v2.data.StoryItemData
const val PICTURE = "https://picsum.photos/200/300"

class Model {
    ////     var picture: MutableLiveData<Int> = MutableLiveData()
////     var storyTitle: MutableLiveData<String> = MutableLiveData()
//
    private var _manItemData: MutableLiveData<ArrayList<ManItemData>>
 //   private var _storyItemData: MutableLiveData<ArrayList<StoryItemData>>
    private var _homeRViewData: MutableLiveData<ArrayList<HomeRViewData>>

    //    private var _brandData: MutableLiveData<ArrayList<Brand>>
//
    init {
        _manItemData = MutableLiveData(getManData())
//        _storyItemData = MutableLiveData(getStoryData())
        _homeRViewData = MutableLiveData(getHomeRViewData())
//        _brandData = MutableLiveData(getBrandData())
    }

    //
//
    var manItemData: LiveData<ArrayList<ManItemData>> = _manItemData
//    var storyItemData: LiveData<ArrayList<StoryItemData>> = _storyItemData
    var homeRViewData : LiveData<ArrayList<HomeRViewData>> = _homeRViewData

    //    var brandData: LiveData<ArrayList<Brand>> = _brandData
//
//
////    fun initV() {
////        manItemData.forEachIndexed { index, storyItemData ->
//////           picture.postValue(storyItemData.image)
//////           storyTitle.postValue(storyItemData.title)
//////          manStoryItemData.add(StoryItemData(0,storyItemData.image,storyItemData.title,false))
////            _manItemData.postValue(manItemData)
////
////            Log.d("StoryITemData", "${this.manItemData.size}")
////
////        }
////    }
//
//

    fun getHomeRViewData(): ArrayList<HomeRViewData>{
        val item : ArrayList<HomeRViewData> = ArrayList()
//        item.add(HomeRViewData(getStoryData(), null,null))
//        repeat(6){
//            item.add(HomeRViewData(null, PICTURE,"Adidas"))
//        }
        return item
    }

//    fun getStoryData(): ArrayList<StoryItemData> {
//        val item: ArrayList<StoryItemData> = ArrayList()
//        item.add(StoryItemData(0, R.drawable.img_3339, "Summer"))
//        item.add(StoryItemData(1, R.drawable.img_3339, "Winter"))
//        item.add(StoryItemData(2, R.drawable.img_3339, "Spring"))
//        item.add(StoryItemData(3, R.drawable.img_3339, "Autumn"))
//        item.add(StoryItemData(4, R.drawable.img_3339, "Next"))
//        return item
//
//    }
//
////    val brand: Brand = testGetBrandData()
////
////    fun testGetBrandData(): Brand {
////        var name : String = " "
////        var _brand : Brand = Brand(0,name)
////        getBrandData().forEach {
////            name = it.brandName
////        }
////         return _brand
////    }
////
    fun getManData(): ArrayList<ManItemData> {
        val item: ArrayList<ManItemData> = ArrayList()
        item.add(ManItemData(0, "Adidas", Brand( "Sportswear"), R.drawable.img_3339, 1022))
        item.add(ManItemData(1, "Nike", Brand( "Nike Air"), R.drawable.img_3338, 1023))
        item.add(ManItemData(2, "Timberland", Brand( "Atwells Ave"), R.drawable.img_3340, 1024))
        item.add(ManItemData(3, "Pull", Brand( "Faux suede"), R.drawable.img_3341, 1025))
        item.add(ManItemData(4, "All-Star", Brand( "Converse"), R.drawable.img_3342, 1026))
        return item
    }
//
//
//
//
////    fun insertData(data: MutableLiveData<ArrayList<ManItemData>>) {
////        _manItemData.postValue(getManData())
////
////    }
//
//
}