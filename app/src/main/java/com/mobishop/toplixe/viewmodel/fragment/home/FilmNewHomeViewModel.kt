package com.mobishop.toplixe.viewmodel.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.film.FilmEntityModel

import com.mobishop.toplixe.repositories.fragment.home.FilmNewHomeRepository

class FilmNewHomeViewModel :ViewModel() {
    private var data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData()
    private val categoryModel: FilmNewHomeRepository = FilmNewHomeRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<FilmEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = categoryModel.dataAPI()
        return data
    }
}