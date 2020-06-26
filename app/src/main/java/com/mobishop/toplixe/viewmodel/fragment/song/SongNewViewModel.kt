package com.mobishop.toplixe.viewmodel.fragment.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.song.SongEntityModel
import com.mobishop.toplixe.repositories.fragment.home.FragmentHomeRepository
import com.mobishop.toplixe.repositories.fragment.song.SongNewRepository

class SongNewViewModel :ViewModel() {
    private var data: MutableLiveData<List<SongEntityModel>> = MutableLiveData()
    private val categoryModel: SongNewRepository =
        SongNewRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<SongEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = categoryModel.dataAPI()
        return data
    }
}