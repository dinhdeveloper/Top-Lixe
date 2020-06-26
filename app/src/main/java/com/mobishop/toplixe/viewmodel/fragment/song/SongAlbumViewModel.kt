package com.mobishop.toplixe.viewmodel.fragment.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.album.AlbumEntityModel
import com.mobishop.toplixe.model.song.SongEntityModel
import com.mobishop.toplixe.repositories.fragment.song.AlbumSongRepository
import com.mobishop.toplixe.repositories.fragment.song.SongNewRepository

class SongAlbumViewModel :ViewModel() {
    private var data: MutableLiveData<List<AlbumEntityModel>> = MutableLiveData()
    private val categoryModel: AlbumSongRepository =
        AlbumSongRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<AlbumEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = categoryModel.dataAPI()
        return data
    }
}