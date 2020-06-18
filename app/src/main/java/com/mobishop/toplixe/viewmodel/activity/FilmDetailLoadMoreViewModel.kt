package com.mobishop.toplixe.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.repositories.activity.FilmDetailRepository
import com.mobishop.toplixe.repositories.fragment.film.FilmHotRepository

class FilmDetailLoadMoreViewModel :ViewModel() {
    private var data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData()
    private val repository: FilmDetailRepository = FilmDetailRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<FilmEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = repository.dataApi()
        return data
    }
}