package com.mobishop.toplixe.viewmodel.fragment.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.song.CategorySongModel
import com.mobishop.toplixe.repositories.fragment.song.CatogorySongRepository

class CategorySongViewModel :ViewModel() {
    private var data: MutableLiveData<List<CategorySongModel>> = MutableLiveData()
    private val sigerModel: CatogorySongRepository = CatogorySongRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<CategorySongModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = sigerModel.dataAPI()
        return data
    }
}