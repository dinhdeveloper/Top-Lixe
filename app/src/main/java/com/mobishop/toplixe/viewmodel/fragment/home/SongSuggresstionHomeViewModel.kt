package com.mobishop.toplixe.viewmodel.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.song.SongEntityModel
import com.mobishop.toplixe.repositories.fragment.home.FragmentHomeRepository
import com.mobishop.toplixe.repositories.fragment.home.SongSuggresstionHomeRepository

class SongSuggresstionHomeViewModel :ViewModel() {
    private var data: MutableLiveData<List<SongEntityModel>> = MutableLiveData()
    private val songRepository: SongSuggresstionHomeRepository =
        SongSuggresstionHomeRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<SongEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = songRepository.dataAPI()
        return data
    }
}