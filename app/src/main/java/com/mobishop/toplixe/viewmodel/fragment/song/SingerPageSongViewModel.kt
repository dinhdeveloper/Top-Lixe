package com.mobishop.toplixe.viewmodel.fragment.song

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.album.AlbumEntityModel
import com.mobishop.toplixe.model.song.SingerEntity
import com.mobishop.toplixe.model.song.SingerEntityModel
import com.mobishop.toplixe.repositories.fragment.song.AlbumSongRepository
import com.mobishop.toplixe.repositories.fragment.song.SingerPageSongRepository

class SingerPageSongViewModel :ViewModel() {
    private var data: MutableLiveData<List<SingerEntityModel>> = MutableLiveData()
    private val sigerModel: SingerPageSongRepository = SingerPageSongRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<SingerEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = sigerModel.dataAPI()
        return data
    }
}