package com.mobishop.toplixe.viewmodel.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.song.SongEntityModel
import com.mobishop.toplixe.repositories.fragment.home.FragmentHomeRepository

class SongRandomHomeViewModel: ViewModel() {
    private var data: MutableLiveData<List<SongEntityModel>> = MutableLiveData()
    private val categoryModel: FragmentHomeRepository =
        FragmentHomeRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<SongEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = categoryModel.dataAPI()
        return data
    }
}