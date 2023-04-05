package com.example.lamoda_v2.man.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lamoda_v2.data.HomeRViewData
import com.example.lamoda_v2.data.ManItemData
import com.example.lamoda_v2.data.StoryItemData
import com.example.lamoda_v2.model.Model


class ManItemViewModel : ViewModel() {

    private var _getManItem: MutableLiveData<ArrayList<ManItemData>>
    private var _getStoryData : MutableLiveData<ArrayList<StoryItemData>>
    private var _homeRViewData : MutableLiveData<ArrayList<HomeRViewData>>

//
//
    val getManItemData: LiveData<ArrayList<ManItemData>>
        get() = _getManItem
    val getStoryItemData: LiveData<ArrayList<StoryItemData>>
        get() = _getStoryData
    val getHomeRViewData : LiveData<ArrayList<HomeRViewData>>
    get() = _homeRViewData

    init {
       val data = Model()
        _getManItem = data.manItemData as MutableLiveData<ArrayList<ManItemData>>
        _getStoryData = data.storyItemData as MutableLiveData<ArrayList<StoryItemData>>
        _homeRViewData = data.homeRViewData as MutableLiveData<ArrayList<HomeRViewData>>
   }




    fun renderManItemData(): MutableLiveData<ArrayList<ManItemData>> {
        val dataModel = Model()
        val item: MutableLiveData<ArrayList<ManItemData>> = MutableLiveData()

        item.postValue(dataModel.getManData())


        return _getManItem
    }


}