package com.mobishop.toplixe.viewmodel.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.repositories.fragment.film.FilmSuggestionRepository
import com.mobishop.toplixe.repositories.fragment.home.FilmSuggestionHomeRepository

class FilmSuggestionHomeViewModel :ViewModel(){
    private var data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData()
    private val repository: FilmSuggestionHomeRepository = FilmSuggestionHomeRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<FilmEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = repository.dataApi()
        return data
    }
}