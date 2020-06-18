package com.mobishop.toplixe.viewmodel.fragment.film

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.repositories.fragment.film.FilmHotRepository

class FilmHasPageViewModel :ViewModel() {
    private var data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData()
    private val repository: FilmHotRepository = FilmHotRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<FilmEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = repository.dataApi()
        return data
    }
}